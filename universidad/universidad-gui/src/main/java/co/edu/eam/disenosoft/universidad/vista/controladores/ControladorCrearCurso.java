
package co.edu.eam.disenosoft.universidad.vista.controladores;
import java.util.List;

import co.edu.eam.disenosoft.universidad.logica.bos.BOAsignatura;
import co.edu.eam.disenosoft.universidad.logica.bos.BOCurso;
import co.edu.eam.disenosoft.universidad.logica.bos.BODocente;
import co.edu.eam.disenosoft.universidad.logica.bos.BOSesionCurso;
import co.edu.eam.disenosoft.universidad.modelo.Asignatura;
import co.edu.eam.disenosoft.universidad.modelo.Curso;
import co.edu.eam.disenosoft.universidad.modelo.Docente;
import co.edu.eam.disenosoft.universidad.modelo.Evaluacion;
import co.edu.eam.disenosoft.universidad.modelo.Profesion;
import co.edu.eam.disenosoft.universidad.modelo.SesionCurso;

public class ControladorCrearCurso {
	
	
	private BOSesionCurso boSesion;
	private BOCurso boCurso;
	
	public ControladorCrearCurso() {
		boSesion = new BOSesionCurso();
		boCurso = new BOCurso();
	}
	
	public void crearSesion (SesionCurso sesion)throws Exception {
		
		boSesion.crearSesion(sesion);
	}
	
	public SesionCurso buscarSesionCurso(int id) throws Exception{
		
		return boSesion.buscarSesionCurso(id);
	}
	
	public List<SesionCurso> listarSesionesCurso(Curso curso) throws Exception{
		
		return boSesion.listarSesionesCurso(curso);
	}
	
	public void eliminarSesion(int id) throws Exception{
		 boSesion.eliminarSesionCurso(id);
	}
	public void editarCurso(SesionCurso sesion) throws Exception{
		boSesion.editar(sesion);
	}
	
	public void crearCurso (Curso curso)throws Exception{
		boSesion.crearCurso(curso);
	}
	
	public Curso buscarCurso (int codigo)throws Exception{
		return  boSesion.buscarCurso(codigo);
	}
	
	public void editarCurso (Curso curso)throws Exception{
		boSesion.editarCurso(curso);
	}

	
	public List<Curso> listarCursos() throws Exception{
		return boCurso.listarCursos();
	}
	
	public List<Evaluacion> listaEvaluaciones(Curso cu) throws Exception {
		return boCurso.listaEvaluaciones(cu);
	}

}
