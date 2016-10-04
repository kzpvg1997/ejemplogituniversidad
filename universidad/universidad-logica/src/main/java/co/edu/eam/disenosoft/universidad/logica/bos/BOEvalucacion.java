
package co.edu.eam.disenosoft.universidad.logica.bos;

import java.util.List;

import co.edu.eam.disenosoft.universidad.modelo.Curso;
import co.edu.eam.disenosoft.universidad.modelo.Evaluacion;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAOEvaluacion;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa.DAOEvaluacionJPA;

public class BOEvalucacion {
	private IDAOEvaluacion dao;
	public BOEvalucacion() {
		dao = new DAOEvaluacionJPA();
	}

	public double porcentajeNoAsignado(Curso curso) throws Exception{
		return dao.porcentajeNoAsignado(curso);		
	}

	public List<Evaluacion> listarEvaluacionesCurso(Curso curso) throws Exception{
		return dao.listarEvaluacionesCurso(curso);
	}

	public void crear(Evaluacion evaluacion) throws Exception {
		dao.crear(evaluacion);
	}

	public void eliminarEvaluacion(Evaluacion evaluacion) throws Exception{
		dao.eliminar(evaluacion);
	}

}
