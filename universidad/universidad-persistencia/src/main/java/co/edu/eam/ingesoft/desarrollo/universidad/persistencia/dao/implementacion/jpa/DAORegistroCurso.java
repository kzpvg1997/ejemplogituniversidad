
package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.edu.eam.disenosoft.universidad.modelo.Curso;
import co.edu.eam.disenosoft.universidad.modelo.Estudiante;
import co.edu.eam.disenosoft.universidad.modelo.RegistroCurso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAORegistroCurso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.utilidades.AdministradorEntityManager;

public class DAORegistroCurso implements IDAORegistroCurso{

	public List<RegistroCurso> registroCursosByAlumno(Estudiante estudiante) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Query q = em.createNamedQuery(RegistroCurso.CURSOS_REGISTRADOS);
		q.setParameter(1, estudiante);
		List<RegistroCurso> registros = q.getResultList();
		return registros;
	}

	public void registrarCurso(RegistroCurso rc) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();
		em.persist(rc);
		em.getTransaction().commit();
	}

	public List<RegistroCurso> listaRegistroCurso(Curso curso) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Query q = em.createNamedQuery(RegistroCurso.LISTA_CURSOS_REGISTRADOS);
		q.setParameter(1, curso);
		List<RegistroCurso> rc = q.getResultList();
		return rc;
	}

	public boolean isRegistrada(RegistroCurso rc) throws Exception {
		List<RegistroCurso> registros = registroCursosByAlumno(rc.getEstudiante());
		for(RegistroCurso registro : registros){
			String cedula1 = registro.getEstudiante().getCedula();
			String cedula2 = rc.getEstudiante().getCedula();
			if(cedula1.equals(cedula2)){
				String materia1 = registro.getCurso().getAsignatura().getCodigo();
				String materia2 = rc.getCurso().getAsignatura().getCodigo();
				if(materia1.equals(materia2)){
					return true;
				}
			}
		}
		return false;
	}

	public RegistroCurso buscarRegistroCurso(Estudiante estudiante, String codigo) throws Exception{
		List<RegistroCurso> registros = registroCursosByAlumno(estudiante);
		for(RegistroCurso registro: registros){
			if(registro.getCurso().getAsignatura().getCodigo().equals(codigo)){
				return registro;
			}
		}
		return null;
	}

	public void eliminarRegistroCurso(RegistroCurso rc) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();
		em.remove(rc);
		em.getTransaction().commit();
	}

	public void editar(RegistroCurso rc) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();
		em.merge(rc);
		em.getTransaction().commit();	
		
	}
}
