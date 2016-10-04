/**
 * 
 */
package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones;

import java.util.List;

import co.edu.eam.disenosoft.universidad.modelo.Curso;
import co.edu.eam.disenosoft.universidad.modelo.Estudiante;
import co.edu.eam.disenosoft.universidad.modelo.Evaluacion;
import co.edu.eam.disenosoft.universidad.modelo.Nota;

/**
 * @author TOSHIBAP55W
 *
 */
public interface IDAONota {

	public void crearNota (Nota nota)throws Exception;
	
	public double verCalifcacion (Curso curso)throws Exception;
	
	public List<Nota> consultaEditada (Nota nota)throws Exception;
	
	public int buscarEvaluacion (Evaluacion id)throws Exception;
	
	public Nota buscarNota (Estudiante es)throws Exception;
	
	public List<Nota> notaByEstudiante (Estudiante estudiante) throws Exception;
	
}
