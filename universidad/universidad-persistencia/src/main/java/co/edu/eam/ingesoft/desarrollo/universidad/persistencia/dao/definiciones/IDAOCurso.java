
package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones;
import java.util.List;
import co.edu.eam.disenosoft.universidad.modelo.Asignatura;
import co.edu.eam.disenosoft.universidad.modelo.Curso;
import co.edu.eam.disenosoft.universidad.modelo.Docente;
import co.edu.eam.disenosoft.universidad.modelo.Estudiante;
import co.edu.eam.disenosoft.universidad.modelo.Evaluacion;
import co.edu.eam.disenosoft.universidad.modelo.RegistroCurso;

public interface IDAOCurso {
	/**
	 * Metodo para crear un curso
	 * @param curso el curso que se desea crear
	 * @throws Exception 
	 */
	public void crear(Curso curso) throws Exception;
	/**
	 * Metodo para editar un curso
	 * @param curso el cursoque se desea editar
	 * @throws Exception
	 */
	public void editar(Curso curso) throws Exception;
	/**
	 * 
	 * @param codigo
	 * @return
	 * @throws Exception
	 */
	public Curso buscar(int codigo) throws Exception;

	public List<Curso> listarCursos() throws Exception;

	public List<Curso> listaCursosByDocente(Docente d) throws Exception;

	public List<Curso> listaCursosByMateria(Asignatura asignatura) throws Exception;
	
	public List<Evaluacion> listaEvaluaciones (Curso cu)throws Exception;
	
}
