
package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.edu.eam.disenosoft.universidad.modelo.Curso;
import co.edu.eam.disenosoft.universidad.modelo.SesionCurso;
import co.edu.eam.disenosoft.universidad.modelo.enumeraciones.DiaEnum;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAOSesionCurso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.utilidades.AdministradorEntityManager;

public class DAOSesionCursoJPA implements IDAOSesionCurso{

	public void crear(SesionCurso sesion) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();
		em.persist(sesion);
		em.getTransaction().commit();	
	}

	public void editar(SesionCurso sesion) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();
		em.merge(sesion);
		em.getTransaction().commit();			
	}

	public SesionCurso buscar(int codigo) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		return em.find(SesionCurso.class, codigo);
	}

	public List<SesionCurso> listarSesionesByCurso(Curso curso) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Query q = em.createNamedQuery(SesionCurso.SESIONES_POR_CURSO);
		q.setParameter(1, curso);
		return q.getResultList();
	}

	public void eliminar(int codigo) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();
		SesionCurso sesion = buscar(codigo);
		if(sesion != null){
			em.remove(sesion);
		}
		em.getTransaction().commit();
	}

	public boolean consultaExistente(DiaEnum dia, int horaInicio, int horaFinal, int codCurso, String cedula)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
