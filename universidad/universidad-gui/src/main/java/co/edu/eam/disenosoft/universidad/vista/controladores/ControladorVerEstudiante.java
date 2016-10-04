
package co.edu.eam.disenosoft.universidad.vista.controladores;

import java.util.List;

import co.edu.eam.disenosoft.universidad.logica.bos.BOCurso;
import co.edu.eam.disenosoft.universidad.logica.bos.BOEvalucacion;
import co.edu.eam.disenosoft.universidad.modelo.Curso;
import co.edu.eam.disenosoft.universidad.modelo.Estudiante;
import co.edu.eam.disenosoft.universidad.modelo.Evaluacion;

public class ControladorVerEstudiante {
	private BOCurso boCurso;
	private BOEvalucacion boEvaluacion;
	public ControladorVerEstudiante() {
		boCurso = new BOCurso();
		boEvaluacion = new BOEvalucacion();
	}

	public int sumaCreditosByAlumno(Estudiante estudiante) throws Exception{
		return boCurso.sumaCreditosByAlumno(estudiante);
	}

	public List<Evaluacion> listarEvaluacionesCurso(Curso curso) throws Exception{
		return boEvaluacion.listarEvaluacionesCurso(curso);
	}
}
