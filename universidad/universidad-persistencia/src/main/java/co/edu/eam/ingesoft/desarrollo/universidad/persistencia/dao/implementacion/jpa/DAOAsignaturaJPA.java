
package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa;
import java.util.List;

import javax.persistence.EntityManager;

import co.edu.eam.disenosoft.universidad.modelo.Asignatura;
import co.edu.eam.disenosoft.universidad.modelo.Docente;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAOAsignatura;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.utilidades.AdministradorEntityManager;

public class DAOAsignaturaJPA implements IDAOAsignatura{

	public void crear(Asignatura asignatura) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();
		em.persist(asignatura);
		em.getTransaction().commit();		
	}

	public void editar(Asignatura asignatura) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();
		em.merge(asignatura);
		em.getTransaction().commit();		
	}

	public void eliminar(String codigo) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();
		Asignatura a = buscar(codigo);
		if(a != null){
			em.remove(a);
		}
		em.getTransaction().commit();
	}

	public Asignatura buscar(String codigo) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		return em.find(Asignatura.class, codigo);
	}
	

	public List<Asignatura> listarTodos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
