package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import co.edu.eam.disenosoft.universidad.modelo.Estudiante;
import co.edu.eam.disenosoft.universidad.modelo.SesionCurso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAOEstudiante;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.utilidades.AdministradorEntityManager;
public class DAOEstudianteJPA implements IDAOEstudiante{

	public void crear(Estudiante estudiante) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();
		em.persist(estudiante);
		em.getTransaction().commit();
	}

	public void editar(Estudiante estudiante) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();
		em.merge(estudiante);
		em.getTransaction().commit();
	}

	public void eliminar(String cedula) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();
		Estudiante e = buscar(cedula);
		if(e != null){
			em.remove(e);
		}
		em.getTransaction().commit();
	}

	public Estudiante buscar(String cedula) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		return em.find(Estudiante.class, cedula);
	}

	public List<Estudiante> listarTodos() throws Exception {
		return null;
	}
}
