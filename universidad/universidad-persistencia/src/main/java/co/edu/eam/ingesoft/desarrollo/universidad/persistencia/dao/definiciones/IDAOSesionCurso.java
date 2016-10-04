/**
 * Interface responsable de definir las operaciones de Sesion Curso
 * @author carlos alfredo martinez villada
 */
package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones;
import java.util.List;


import co.edu.eam.disenosoft.universidad.modelo.SesionCurso;
import co.edu.eam.disenosoft.universidad.modelo.enumeraciones.DiaEnum;
import co.edu.eam.disenosoft.universidad.modelo.Curso;

public interface IDAOSesionCurso {
	public void crear(SesionCurso sesion) throws Exception;
	public void editar(SesionCurso sesion) throws Exception;
	public SesionCurso buscar(int codigo) throws Exception;
	public List<SesionCurso> listarSesionesByCurso(Curso curso) throws Exception;
	public void eliminar(int codigo) throws Exception;
	public boolean consultaExistente (DiaEnum dia,int horaInicio,int horaFinal,int codCurso,String cedula)throws Exception;
}
