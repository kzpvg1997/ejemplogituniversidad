/**
 * Clase responsable de realizar las operaciones de Profesion.
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
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAOProfesion;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.utilidades.AdministradorConexionJDBC;

public class DAOProfesionJDBC implements IDAOProfesion{
	/**
	 * Lista todos las Profesiones que se encuentren registrados en la base de datos.
	 * @throws SQLException 
	 */
	public List<Profesion> listarTodos() throws SQLException {
		Connection con = AdministradorConexionJDBC.getConexion();
		List<Profesion> lista = new ArrayList<Profesion>();
		String sql = "SELECT codigo_prof, nombre_prof FROM universidad.tb_profesion";
		PreparedStatement pstmt=con.prepareStatement(sql);
		ResultSet res = pstmt.executeQuery();
		while(res.next()){
    		String codigo = res.getString(1); 
    		String nombre = res.getString(2); 
    		Profesion profesion = new Profesion(codigo, nombre);
    		lista.add(profesion);
		}
		con.close();
		return lista;
	}
}
