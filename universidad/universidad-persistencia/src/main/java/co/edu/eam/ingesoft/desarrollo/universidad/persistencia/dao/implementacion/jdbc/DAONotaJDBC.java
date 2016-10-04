/**
 * 
 */
package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import co.edu.eam.disenosoft.universidad.modelo.Curso;
import co.edu.eam.disenosoft.universidad.modelo.Docente;
import co.edu.eam.disenosoft.universidad.modelo.Estudiante;
import co.edu.eam.disenosoft.universidad.modelo.Evaluacion;
import co.edu.eam.disenosoft.universidad.modelo.Nota;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAONota;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.utilidades.AdministradorConexionJDBC;

/**
 * @author TOSHIBAP55W
 *
 */
public class DAONotaJDBC implements IDAONota{

	public void crearNota(Nota nota) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean editada(Nota editada) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public double verCalifcacion(Curso curso) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Nota> consultaEditada(Nota nota) throws Exception{
		
		Connection con = AdministradorConexionJDBC.getConexion();
		
		String sql = "select valor_nota from tb_nota  where codigo_cur=?";
		
		
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setInt(1, nota.getEvaluacion().getCurso().getCodigo());
		

		// Ejecutar consulta
		ResultSet res = pstmt.executeQuery();
		
		return null;
	}


	public int buscarEvaluacion(Evaluacion id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public Nota buscarNota(Estudiante es) throws Exception {
		Connection con = AdministradorConexionJDBC.getConexion();
		String sql = "select n.ID from tb_nota n where n.cedula_est=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		//pstmt.setString(1, es);
		ResultSet res = pstmt.executeQuery();
		Docente docente = null;
		return null;
	}

	public List<Nota> notaByEstudiante(Estudiante estudiante) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
