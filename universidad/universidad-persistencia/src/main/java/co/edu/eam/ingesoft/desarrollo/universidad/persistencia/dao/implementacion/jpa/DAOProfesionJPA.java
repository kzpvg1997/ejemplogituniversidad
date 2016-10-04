
package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.edu.eam.disenosoft.universidad.modelo.Docente;
import co.edu.eam.disenosoft.universidad.modelo.Profesion;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAOProfesion;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.utilidades.AdministradorEntityManager;

public class DAOProfesionJPA implements IDAOProfesion{
	

	public List<Profesion> listarTodos() throws Exception {
		String jpql = "SELECT pro FROM Profesion pro";
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Query q = em.createQuery(jpql);
		List<Profesion> profesiones = q.getResultList();
		return profesiones;
	}

}
