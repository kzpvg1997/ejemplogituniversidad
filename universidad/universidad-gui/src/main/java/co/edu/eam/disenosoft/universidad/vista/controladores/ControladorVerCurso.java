
package co.edu.eam.disenosoft.universidad.vista.controladores;

import java.util.List;

import co.edu.eam.disenosoft.universidad.logica.bos.BOAsignatura;
import co.edu.eam.disenosoft.universidad.logica.bos.BOCurso;
import co.edu.eam.disenosoft.universidad.modelo.Asignatura;
import co.edu.eam.disenosoft.universidad.modelo.Curso;
import co.edu.eam.disenosoft.universidad.modelo.Docente;
import co.edu.eam.disenosoft.universidad.modelo.Estudiante;
import co.edu.eam.disenosoft.universidad.modelo.RegistroCurso;

public class ControladorVerCurso {
	
	private BOAsignatura boAsignatura;
	private BOCurso boCurso;
	public ControladorVerCurso() {
		boAsignatura = new BOAsignatura();
		boCurso = new BOCurso();
	}

	public Asignatura buscarAsignatura(String codigo) throws Exception{
		return boAsignatura.buscar(codigo);
	}	

	public List<Curso> listaCursosByMateria(Asignatura a) throws Exception{
		return boCurso.listaCursosByMateria(a);
	}

	public List<RegistroCurso> listaEstudiantesCurso(Curso curso) throws Exception{
		return boCurso.listaEstudiantesCurso(curso);
	}
	
	public List<Curso> listaCursosByDocente(Docente d) throws Exception{
		return boCurso.listaCursosByDocente(d);
	}
}
