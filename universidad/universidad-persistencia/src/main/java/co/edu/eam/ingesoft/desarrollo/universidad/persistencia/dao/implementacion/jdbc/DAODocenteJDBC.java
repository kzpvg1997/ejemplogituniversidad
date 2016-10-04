/**
 * Clase responsable de realizar las operaciones de docente.
 * @author carlos alfredo martinez villada
 */
package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import co.edu.eam.disenosoft.universidad.modelo.Docente;
import co.edu.eam.disenosoft.universidad.modelo.Profesion;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAODocente;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.utilidades.AdministradorConexionJDBC;

public class DAODocenteJDBC implements IDAODocente {
	/**
	 * Registra un Docente con toda su informacion en la Base de datos.
	 */
	public void crear(Docente docente) throws SQLException {
		Connection con = AdministradorConexionJDBC.getConexion();
		/* Construimos la consulta sql */
		String sql = "INSERT INTO universidad."
				+ "tb_persona (cedula_per, apellido_per, correo_per, direccion_per, nombre_per, telefono_per) "
				+ "VALUES (?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, docente.getCedula());
		pstmt.setString(2, docente.getApellido());
		pstmt.setString(3, docente.getCorreo());
		pstmt.setString(4, docente.getDireccion());
		pstmt.setString(5, docente.getNombre());
		pstmt.setString(6, docente.getTelefono());
		
		String sql2 = "INSERT INTO universidad."
				+ "tb_docente (cedula_per, postgrado_doc, profesion_doc) VALUES (?,?,?)";
		PreparedStatement pstmt2 = con.prepareStatement(sql2);
		pstmt2.setString(1, docente.getCedula());
		pstmt2.setBoolean(2, docente.isPostgrado());
		pstmt2.setString(3, docente.getProfesion().getCodigo());
		/* Ejecutamos la consulta sql */
		pstmt.executeUpdate();
		pstmt2.executeUpdate();
		/*
		 * Cerramos la conexion. | Asi evitamos consumo inecesario de recursos
		 */
		con.close();
	}

	public void editar(Docente docente) throws SQLException {
		Connection con = AdministradorConexionJDBC.getConexion();
		/* Construimos la consulta sql */
		String sql="UPDATE universidad.tb_persona SET "
				+ "apellido_per = ?, "
				+ "correo_per = ?, "
				+ "direccion_per = ?, "
				+ "nombre_per = ?, "
				+ "telefono_per = ? "
				+ "WHERE cedula_per = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, docente.getApellido());
		pstmt.setString(2, docente.getCorreo());
		pstmt.setString(3, docente.getDireccion());
		pstmt.setString(4, docente.getNombre());
		pstmt.setString(5, docente.getTelefono());
		pstmt.setString(6, docente.getCedula());
		
		String sql2 = "UPDATE universidad.tb_docente SET "
				+ "postgrado_doc = ?, "
				+ "profesion_doc = ? "
				+ "WHERE cedula_per = ?";
		PreparedStatement pstmt2 = con.prepareStatement(sql2);
		pstmt2.setBoolean(1, docente.isPostgrado());
		pstmt2.setString(2, docente.getProfesion().getCodigo());
		pstmt2.setString(3, docente.getCedula());
		/* Ejecutamos la consulta sql */
		pstmt.executeUpdate();
		pstmt2.executeUpdate();
		/*
		 * Cerramos la conexion. | Asi evitamos consumo inecesario de recursos
		 */
		con.close();
	}
	/* Elimina un profesor de la BD de la tabla docente y tabla persona*/
	public void eliminar(String cedula) throws SQLException {
		Connection con = AdministradorConexionJDBC.getConexion();
		String sql = "DELETE FROM universidad.tb_docente WHERE cedula_per = ?";
//		String sql2 = "DELETE p.tb_persona, d.tb_docente FROM universidad.tb_persona p "
//				+ "INNER JOIN universidad.tb_docente d ON p.cedula_per = d.cedula_per "
//				+ "WHERE cedula_per = "+cedula;
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, cedula);
		String sql2 = "DELETE FROM universidad.tb_persona WHERE cedula_per = ?";
		PreparedStatement pstmt2 = con.prepareStatement(sql2);
		pstmt2.setString(1, cedula);
		pstmt.executeUpdate();
		pstmt2.executeUpdate();
		con.close();
	}

	/**
	 * Busca un Docente por su numero de cedula.
	 * 
	 * @throws SQLException
	 */
	public Docente buscar(String cedula) throws SQLException {
		Connection con = AdministradorConexionJDBC.getConexion();
		String sql = "SELECT p.apellido_per, p.correo_per, p.direccion_per, p.nombre_per,"
				+ " p.telefono_per, d.postgrado_doc, d.profesion_doc, f.nombre_prof"
				+ " FROM universidad.tb_persona p INNER JOIN universidad.tb_docente d"
				+ " ON p.cedula_per = d.cedula_per INNER JOIN universidad.tb_profesion f"
				+ " ON d.profesion_doc = f.codigo_prof WHERE p.cedula_per = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, cedula);
		ResultSet res = pstmt.executeQuery();
		Docente docente = null;
		/* Si hubo un registro */
		if (res.next()) {
			String apellido = res.getString(1);
			String correo = res.getString(2);
			String direccion = res.getString(3);
			String nombre = res.getString(4);
			String telefono = res.getString(5);
			boolean postgrado = res.getBoolean(6);
			String codigoProfesion = res.getString(7);
			String nombreProfesion = res.getString(8);
			Profesion profesion = new Profesion(codigoProfesion, nombreProfesion);
			docente = new Docente(cedula, apellido, correo, direccion, nombreProfesion, telefono, postgrado, profesion);
		}
		con.close();
		return docente;
	}

	/**
	 * Lista todos los Docentes que se encuentren registrados en la base de
	 * datos
	 * 
	 * @throws SQLException
	 */
	public List<Docente> listarTodos() throws SQLException {
		List<Docente> lista = new ArrayList<Docente>();
		Connection con = AdministradorConexionJDBC.getConexion();
		String sql = "SELECT p.cedula_per, p.apellido_per, p.correo_per, p.direccion_per, p.nombre_per,"
				+ " p.telefono_per, d.postgrado_doc, d.profesion_doc, f.nombre_prof"
				+ " FROM universidad.tb_persona p INNER JOIN universidad.tb_docente d"
				+ " ON p.cedula_per = d.cedula_per INNER JOIN universidad.tb_profesion f"
				+ " ON d.profesion_doc = f.codigo_prof";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet res = pstmt.executeQuery();
		while (res.next()) {
			String cedula = res.getString(1);
			String apellido = res.getString(2);
			String correo = res.getString(3);
			String direccion = res.getString(4);
			String nombre = res.getString(5);
			String telefono = res.getString(6);
			boolean postgrado = res.getBoolean(7);
			String codigoProfesion = res.getString(8);
			String nombreProfesion = res.getString(9);
			Profesion profesion = new Profesion(codigoProfesion, nombreProfesion);
			Docente docente = new Docente(cedula, apellido, correo, direccion, nombreProfesion, telefono, postgrado, profesion);
			lista.add(docente);
		}
		con.close();
		return lista;
	}

}
