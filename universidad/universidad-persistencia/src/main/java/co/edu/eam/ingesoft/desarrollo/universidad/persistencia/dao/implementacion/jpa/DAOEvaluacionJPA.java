
package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.edu.eam.disenosoft.universidad.modelo.Asignatura;
import co.edu.eam.disenosoft.universidad.modelo.Curso;
import co.edu.eam.disenosoft.universidad.modelo.Evaluacion;
import co.edu.eam.disenosoft.universidad.modelo.Profesion;
import co.edu.eam.disenosoft.universidad.modelo.RegistroCurso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAOEvaluacion;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.utilidades.AdministradorEntityManager;

public class DAOEvaluacionJPA implements IDAOEvaluacion{

	public void crear(Evaluacion evaluacion) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();
		em.persist(evaluacion);
		em.getTransaction().commit();		
	}

	public void eliminar(Evaluacion evaluacion) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();
		em.remove(evaluacion);
		em.getTransaction().commit();
	}

	public List<Evaluacion> listarEvaluacionesCurso(Curso curso) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Query q = em.createNamedQuery(Evaluacion.EVALUACIONES_CURSO);
		q.setParameter(1, curso);
		List<Evaluacion> evaluaciones = q.getResultList();
		return evaluaciones;
	}

	public double porcentajeNoAsignado(Curso curso) throws Exception{
		List<Evaluacion> evaluaciones = listarEvaluacionesCurso(curso);
		Double porcentaje = 0.0;
		for(Evaluacion evaluacion : evaluaciones){
			porcentaje += evaluacion.getPorcentaje();
		}
		return 100-porcentaje;
	}
	

}
