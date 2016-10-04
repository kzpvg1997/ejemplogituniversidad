/**
 * 
 */
package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import co.edu.eam.disenosoft.universidad.modelo.Curso;
import co.edu.eam.disenosoft.universidad.modelo.SesionCurso;
import co.edu.eam.disenosoft.universidad.modelo.enumeraciones.DiaEnum;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAOSesionCurso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.utilidades.AdministradorConexionJDBC;

/**
 * @author TOSHIBAP55W
 *
 */
public class DAOSesionCursoJDBC implements IDAOSesionCurso{

	public void crear(SesionCurso sesion) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void editar(SesionCurso sesion) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public SesionCurso buscar(int codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SesionCurso> listarSesionesByCurso(Curso curso) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void eliminar(int codigo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean consultaExistente(DiaEnum dia, int horaInicio, int horaFinal, int codCurso, String cedula)throws Exception {
		Connection con = AdministradorConexionJDBC.getConexion();
//		System.out.println(dia);
//		System.out.println(horaInicio);
//		System.out.println(horaFinal);
//		System.out.println(codCurso);
//		System.out.println(cedula);
//		
		//String sql = "SELECT ID FROM tb_sesioncurso WHERE dia_sesion = '"+dia+"' AND  (("+horaInicio+" >= horainicio_sesion  and "+horaInicio+" < horafinal_sesion) or ("+horaFinal+" > horainicio_sesion  and "+horaFinal+" <= horafinal_sesion))  and codigo_curso  = '"+codCurso+"'";
		
		
		String sql = "SELECT sc.ID FROM tb_sesioncurso sc join tb_docente doc WHERE dia_sesion = ? AND  ((? >= horainicio_sesion  and ? < horafinal_sesion) or (? > horainicio_sesion  and ? <= horafinal_sesion))  and codigo_curso  = ? and doc.cedula_per=?";
		
		
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, ""+dia);
		pstmt.setInt(2, horaInicio);
		pstmt.setInt(3, horaInicio);		
		pstmt.setInt(4, horaFinal);		
		pstmt.setInt(5, horaFinal);
		pstmt.setInt(6, codCurso);
		pstmt.setString(7, cedula);

		// Ejecutar consulta
		ResultSet res = pstmt.executeQuery();
		

		if (res.next()){

			//System.out.println("si existe");		
			con.close();
			return false;

		}else{
		
			//System.out.println("no hay datos");
			con.close();
			return true;
		}
		
	}

}
