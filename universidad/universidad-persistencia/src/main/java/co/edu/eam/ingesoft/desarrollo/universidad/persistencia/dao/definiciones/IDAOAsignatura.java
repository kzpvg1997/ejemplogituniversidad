
package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones;
import java.util.List;
import co.edu.eam.disenosoft.universidad.modelo.Asignatura;

public interface IDAOAsignatura {

	public void crear(Asignatura asignatura) throws Exception;

	public void editar(Asignatura asignatura) throws Exception;

	public void eliminar(String codigo) throws Exception;

	public Asignatura buscar(String codigo) throws Exception;

	public List<Asignatura> listarTodos() throws Exception;
}
