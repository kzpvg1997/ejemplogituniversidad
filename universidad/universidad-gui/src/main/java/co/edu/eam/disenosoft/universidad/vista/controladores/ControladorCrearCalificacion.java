package co.edu.eam.disenosoft.universidad.vista.controladores;
import java.util.List;

import co.edu.eam.disenosoft.universidad.logica.bos.BOAsignatura;
import co.edu.eam.disenosoft.universidad.logica.bos.BOCurso;
import co.edu.eam.disenosoft.universidad.logica.bos.BOEvalucacion;
import co.edu.eam.disenosoft.universidad.logica.excepciones.ExcepcionNegocio;
import co.edu.eam.disenosoft.universidad.modelo.Asignatura;
import co.edu.eam.disenosoft.universidad.modelo.Curso;
import co.edu.eam.disenosoft.universidad.modelo.Evaluacion;
import co.edu.eam.disenosoft.universidad.modelo.Nota;

public class ControladorCrearCalificacion {
	
	private BOAsignatura boAsignatura;
	private BOCurso boCurso;
	private BOEvalucacion boEvaluacion;
	public ControladorCrearCalificacion() {
		boAsignatura = new BOAsignatura();
		boCurso = new BOCurso();
		boEvaluacion = new BOEvalucacion();
	}

	public Asignatura buscarAsignatura(String codigo) throws Exception{
		return boAsignatura.buscar(codigo);
	}	
	public List<Curso> listaCursosByMateria(Asignatura a) throws Exception{
		return boCurso.listaCursosByMateria(a);
	}
	public Double porcentajeNoAsignado(Curso curso) throws Exception{
		return boEvaluacion.porcentajeNoAsignado(curso);
	}
	public void crearEvaluacion(Evaluacion evaluacion) throws Exception{
		Double porcentaje = porcentajeNoAsignado(evaluacion.getCurso());
		Double total = porcentaje - evaluacion.getPorcentaje();
		if(total < 0){
			throw new ExcepcionNegocio("No se puede Crear esta evaluacion\npor que supera el maximo de porcentaje");
		}else{
			boEvaluacion.crear(evaluacion);
		}
	}
	public List<Evaluacion> listarEvaluacionesCurso(Curso curso) throws Exception{
		return boEvaluacion.listarEvaluacionesCurso(curso);
	}
	public void eliminarEvaluacion(Evaluacion evaluacion) throws Exception{
			boEvaluacion.eliminarEvaluacion(evaluacion);
	}
}
