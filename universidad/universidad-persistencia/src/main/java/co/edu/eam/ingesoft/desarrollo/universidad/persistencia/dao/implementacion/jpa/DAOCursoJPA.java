
package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.edu.eam.disenosoft.universidad.modelo.Asignatura;
import co.edu.eam.disenosoft.universidad.modelo.Curso;
import co.edu.eam.disenosoft.universidad.modelo.Docente;
import co.edu.eam.disenosoft.universidad.modelo.Estudiante;
import co.edu.eam.disenosoft.universidad.modelo.Evaluacion;
import co.edu.eam.disenosoft.universidad.modelo.Profesion;
import co.edu.eam.disenosoft.universidad.modelo.RegistroCurso;
import co.edu.eam.disenosoft.universidad.modelo.SesionCurso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAOCurso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.utilidades.AdministradorEntityManager;

public class DAOCursoJPA implements IDAOCurso{

	public void crear(Curso curso) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();
		em.persist(curso);
		em.getTransaction().commit();		
	}

	public void editar(Curso curso) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();
		em.merge(curso);
		em.getTransaction().commit();		
	}

	public Curso buscar(int codigo) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		return em.find(Curso.class, codigo);
	}

	public List<Curso> listarCursos() throws Exception {
		String jpql = "SELECT co FROM Curso co";
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Query q = em.createQuery(jpql);
		List<Curso> cursos = q.getResultList();
		return cursos;
	}

	public List<Curso> listaCursosByMateria(Asignatura asignatura){
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Query q = em.createNamedQuery(Curso.CURSOS_MATERIA);
		q.setParameter(1, asignatura);
		List<Curso> cursos = q.getResultList();
		return cursos;
	}

	public List<Curso> listaCursosByDocente(Docente d) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Query q = em.createNamedQuery(Curso.CURSOS_DOCENTE);
		q.setParameter(1, d);
		List<Curso> cursos = q.getResultList();
		return cursos;
	}

	public List<Evaluacion> listaEvaluaciones(Curso cu) throws Exception {
		
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Query q = em.createNamedQuery(Curso.EVALUACIONES_PORCURSO);
		q.setParameter(1, cu);
		List<Evaluacion> evaluaciones = q.getResultList();
		return evaluaciones;
	}
}
