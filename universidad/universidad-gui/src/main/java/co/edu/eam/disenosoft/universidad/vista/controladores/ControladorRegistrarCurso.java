
package co.edu.eam.disenosoft.universidad.vista.controladores;
import java.util.List;

import co.edu.eam.disenosoft.universidad.logica.bos.BOAsignatura;
import co.edu.eam.disenosoft.universidad.logica.bos.BOCurso;
import co.edu.eam.disenosoft.universidad.logica.bos.BOEstudiante;
import co.edu.eam.disenosoft.universidad.modelo.Asignatura;
import co.edu.eam.disenosoft.universidad.modelo.Curso;
import co.edu.eam.disenosoft.universidad.modelo.Estudiante;
import co.edu.eam.disenosoft.universidad.modelo.RegistroCurso;

public class ControladorRegistrarCurso {
	
	private BOEstudiante boEstudiante;
	private BOAsignatura boAsignatura;
	private BOCurso boCurso;
	public ControladorRegistrarCurso() {
		boEstudiante = new BOEstudiante();
		boAsignatura = new BOAsignatura();
		boCurso = new BOCurso();
	}

	public Estudiante buscarEstudiante(String cedula) throws Exception{
		return boEstudiante.buscar(cedula);
	}	

	public Asignatura buscarAsignatura(String codigo) throws Exception{
		return boAsignatura.buscar(codigo);
	}

	public int sumaCreditosByAlumno(Estudiante estudiante) throws Exception{
		return boCurso.sumaCreditosByAlumno(estudiante);
	}

	public List<Curso> listaCursosByMateria(Asignatura asignatura) throws Exception{
		return boCurso.listaCursosByMateria(asignatura);
	}

	public Curso buscarCurso(int codigo) throws Exception{
		return boCurso.buscar(codigo);
	}
	

	public void registrarCurso(RegistroCurso rc) throws Exception{
		boCurso.registrarCurso(rc);
	}

	public RegistroCurso buscarRegistroCurso(Estudiante estudiante, String codigo) throws Exception{
		return boCurso.buscarRegistroCurso(estudiante, codigo);
	}

	public void eliminarRegistroCurso(RegistroCurso rc) throws Exception{
		boCurso.eliminarRegistroCurso(rc);
	}
	
}
