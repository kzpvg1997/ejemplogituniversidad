/**
 * 
 */
package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.edu.eam.disenosoft.universidad.modelo.Curso;
import co.edu.eam.disenosoft.universidad.modelo.Estudiante;
import co.edu.eam.disenosoft.universidad.modelo.Evaluacion;
import co.edu.eam.disenosoft.universidad.modelo.Nota;
import co.edu.eam.disenosoft.universidad.modelo.RegistroCurso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAONota;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.utilidades.AdministradorEntityManager;

/**
 * @author TOSHIBAP55W
 *
 */
public class DAONotaJPA implements IDAONota{

	public void crearNota(Nota nota) throws Exception {
		
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();
		em.persist(nota);
		em.getTransaction().commit();
	}

	public List<Nota> consultaEditada(Nota nota) throws Exception{
		
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Query q = em.createNamedQuery(Nota.CONSULTA_EDITADA);
		q.setParameter(1, nota);
		List<Nota> notas = q.getResultList();
		
		return notas;
	}


	public double verCalifcacion(Curso curso)throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}


	public int buscarEvaluacion(Evaluacion id) throws Exception {
			
		EntityManager em = AdministradorEntityManager.getEntityManager();
			Query q = em.createNamedQuery(Evaluacion.CONSULTA_ID_EVALUACION);
			q.setParameter(1, id);
			return q.getFirstResult();
		}

	public Nota buscarNota(Estudiante es) throws Exception {
		
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Query q = em.createNamedQuery(Nota.CONSULTA_ID_NOTA);
		q.setParameter(1,es);
		return null;
	}

	public List<Nota> notaByEstudiante(Estudiante estudiante) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Query q = em.createNamedQuery(Nota.CONSULTA_NOTA_CURSO);
		q.setParameter(1, estudiante);
		List<Nota> notas = q.getResultList();
		return notas;
	}

	public void editarNota(Nota nota) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();
		em.merge(nota);
		em.getTransaction().commit();
	}

	
}
