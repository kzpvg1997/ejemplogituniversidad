/**
 * Clase responsable de Administrar la Conexion JDBC
 * @author carlos alfredo martinez villada
 */
package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.utilidades;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class AdministradorConexionJDBC{
	public static Connection getConexion() throws SQLException{
		System.out.println("Conectandose...");
		String url = "jdbc:mysql://localhost:3306/universidad";
		String user = "root";
		String pass = "1234";
		Connection con = DriverManager.getConnection(url, user, pass);
		return con;
	}

}
