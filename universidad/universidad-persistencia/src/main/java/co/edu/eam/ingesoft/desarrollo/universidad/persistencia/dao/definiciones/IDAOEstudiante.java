/**
 * Interface responsable de definir las operaciones de Estudiante
 * @author carlos alfredo martinez villada
 */
package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones;
import java.util.List;
import co.edu.eam.disenosoft.universidad.modelo.Estudiante;
public interface IDAOEstudiante {
	public void crear(Estudiante estudiante) throws Exception;
	public void editar(Estudiante estudiante) throws Exception;
	public void eliminar(String cedula) throws Exception;
	public Estudiante buscar(String cedula) throws Exception;
	public List<Estudiante> listarTodos() throws Exception;
}

