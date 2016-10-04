
package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones;

import java.util.List;

import co.edu.eam.disenosoft.universidad.modelo.Curso;
import co.edu.eam.disenosoft.universidad.modelo.Estudiante;
import co.edu.eam.disenosoft.universidad.modelo.Nota;
import co.edu.eam.disenosoft.universidad.modelo.RegistroCurso;

public interface IDAORegistroCurso {

	public List<RegistroCurso> registroCursosByAlumno(Estudiante estudiante) throws Exception;

	public void registrarCurso(RegistroCurso rc) throws Exception;

	public void editar(RegistroCurso rc) throws Exception;

	public List<RegistroCurso> listaRegistroCurso(Curso curso) throws Exception;
	

	public boolean isRegistrada(RegistroCurso rc) throws Exception;

	public RegistroCurso buscarRegistroCurso(Estudiante e, String codigo) throws Exception;

	public void eliminarRegistroCurso(RegistroCurso rc) throws Exception;

}
