/**
 * Clase responsable de realizar las operaciones de Estudiante
 * @author carlos alfredo martinez villada
 */
package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jdbc;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.eam.disenosoft.universidad.modelo.Docente;
import co.edu.eam.disenosoft.universidad.modelo.Estudiante;
import co.edu.eam.disenosoft.universidad.modelo.Profesion;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAOEstudiante;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.utilidades.AdministradorConexionJDBC;

public class DAOEstudianteJDBC implements IDAOEstudiante{
	/**
	 * Registra un Estudiante con toda su informacion en la Base de datos.
	 */
	public void crear(Estudiante estudiante) throws Exception {
		Connection con = AdministradorConexionJDBC.getConexion();
		/* Construimos la consulta sql */
		String sql = "INSERT INTO universidad."
				+ "tb_persona (cedula_per, apellido_per, correo_per, direccion_per, nombre_per, telefono_per) "
				+ "VALUES (?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, estudiante.getCedula());
		pstmt.setString(2, estudiante.getApellido());
		pstmt.setString(3, estudiante.getCorreo());
		pstmt.setString(4, estudiante.getDireccion());
		pstmt.setString(5, estudiante.getNombre());
		pstmt.setString(6, estudiante.getTelefono());
		
		String sql2 = "INSERT INTO universidad."
				+ "tb_Estudiante (cedula_per, fechanacimiento_est) VALUES (?,?)";
		PreparedStatement pstmt2 = con.prepareStatement(sql2);
		pstmt2.setString(1, estudiante.getCedula());
		pstmt2.setDate(2, new Date(estudiante.getFechaNacimiento().getTime()));
		/* Ejecutamos la consulta sql */
		pstmt.executeUpdate();
		pstmt2.executeUpdate();
		/*
		 * Cerramos la conexion. | Asi evitamos consumo inecesario de recursos
		 */
		con.close();
	}

	public void editar(Estudiante estudiante) throws Exception {
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
		pstmt.setString(1, estudiante.getApellido());
		pstmt.setString(2, estudiante.getCorreo());
		pstmt.setString(3, estudiante.getDireccion());
		pstmt.setString(4, estudiante.getNombre());
		pstmt.setString(5, estudiante.getTelefono());
		pstmt.setString(6, estudiante.getCedula());
		
		String sql2 = "UPDATE universidad.tb_Estudiante SET "
				+ "fechanacimiento_est = ? "
				+ "WHERE cedula_per = ?";
		PreparedStatement pstmt2 = con.prepareStatement(sql2);
		pstmt2.setDate(1, new Date (estudiante.getFechaNacimiento().getTime()));
		pstmt2.setString(2, estudiante.getCedula());
		/* Ejecutamos la consulta sql */
		pstmt.executeUpdate();
		pstmt2.executeUpdate();
		/*
		 * Cerramos la conexion. | Asi evitamos consumo inecesario de recursos
		 */
		con.close();
	}
	/* Elimina un estudiante de la BD de la tabla estudiante y tabla persona*/
	public void eliminar(String cedula) throws Exception {
			Connection con = AdministradorConexionJDBC.getConexion();
			String sql = "DELETE FROM universidad.tb_Estudiante WHERE cedula_per = ?";
//			String sql2 = "DELETE p.tb_persona, d.tb_docente FROM universidad.tb_persona p "
//					+ "INNER JOIN universidad.tb_docente d ON p.cedula_per = d.cedula_per "
//					+ "WHERE cedula_per = "+cedula;
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
	 * Metodo que busca un estudiante por su cedula
	 */
	public Estudiante buscar(String cedula) throws Exception {
		Connection con = AdministradorConexionJDBC.getConexion();
		String sql = "SELECT p.apellido_per, p.correo_per, p.direccion_per, p.nombre_per,"
				+ " p.telefono_per, e.fechanacimiento_est"
				+ " FROM universidad.tb_persona p INNER JOIN universidad.tb_Estudiante e"
				+ " ON p.cedula_per = e.cedula_per WHERE p.cedula_per = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, cedula);
		ResultSet res = pstmt.executeQuery();
		Estudiante estudiante = null;
		/* Si hubo un registro */
		if (res.next()) {
			String apellido = res.getString(1);
			String correo = res.getString(2);
			String direccion = res.getString(3);
			String nombre = res.getString(4);
			String telefono = res.getString(5);
			Date fechaNacimiento = res.getDate(6);
			estudiante = new Estudiante(nombre, apellido, cedula, correo, direccion, telefono, fechaNacimiento);
		}
		con.close();
		return estudiante;
	}
	/**
	 * Metodo que devuelve una lista con todos los estudiantes registrados en la BD
	 */
	public List<Estudiante> listarTodos() throws Exception {
		List<Estudiante> lista = new ArrayList<Estudiante>();
		Connection con = AdministradorConexionJDBC.getConexion();
		String sql = "SELECT p.apellido_per, p.correo_per, p.direccion_per, p.nombre_per "
				+ "p.telefono_per, e.fechanacimiento_est, e.cedula_per"
				+ "FROM universidad.tb_persona p INNER JOIN universidad.tb_Estudiante e"
				+ "ON p.cedula_per = e.cedula_per";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet res = pstmt.executeQuery();
		while (res.next()) {
			String apellido = res.getString(1);
			String correo = res.getString(2);
			String direccion = res.getString(3);
			String nombre = res.getString(4);
			String telefono = res.getString(5);
			Date fechaNacimiento = res.getDate(6);
			String cedula = res.getString(7);
			Estudiante estudiante = new Estudiante(nombre, apellido, cedula, correo, direccion, telefono, fechaNacimiento);
			lista.add(estudiante);
		}
		con.close();
		return lista;
	}

}
