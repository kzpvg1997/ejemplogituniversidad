
package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones;
import java.util.List;

import co.edu.eam.disenosoft.universidad.modelo.Curso;
import co.edu.eam.disenosoft.universidad.modelo.Evaluacion;

public interface IDAOEvaluacion {

	public void crear(Evaluacion evaluacion) throws Exception;

	public void eliminar(Evaluacion evaluacion) throws Exception;
	

	public List<Evaluacion> listarEvaluacionesCurso(Curso curso) throws Exception;

	public double porcentajeNoAsignado(Curso curso) throws Exception;
	

}
