package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa;
import javax.persistence.EntityManager;
import co.edu.eam.disenosoft.universidad.modelo.Persona;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAOPersona;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.utilidades.AdministradorEntityManager;

public class DAOPersonaJPA implements IDAOPersona{

	public Persona buscar(String cedula) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		return em.find(Persona.class, cedula);
	}

}
