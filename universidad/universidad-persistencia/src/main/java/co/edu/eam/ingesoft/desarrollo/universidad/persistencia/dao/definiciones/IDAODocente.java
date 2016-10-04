/**
 * 
 */
package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones;
import java.util.List;
import co.edu.eam.disenosoft.universidad.modelo.Docente;

/**
 * Interface responsable de definir las operaciones de docente
 * @author carlos alfredo martinez villada
 */
public interface IDAODocente {
	public void crear(Docente docente) throws Exception;
	public void editar(Docente docente) throws Exception;
	public void eliminar(String cedula) throws Exception;
	public Docente buscar(String cedula) throws Exception;
	public List<Docente> listarTodos() throws Exception;
}
