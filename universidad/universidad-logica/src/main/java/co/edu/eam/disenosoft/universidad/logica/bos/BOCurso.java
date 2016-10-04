
package co.edu.eam.disenosoft.universidad.logica.bos;
import java.util.List;

import co.edu.eam.disenosoft.universidad.logica.excepciones.ExcepcionNegocio;
import co.edu.eam.disenosoft.universidad.modelo.Asignatura;
import co.edu.eam.disenosoft.universidad.modelo.Curso;
import co.edu.eam.disenosoft.universidad.modelo.Docente;
import co.edu.eam.disenosoft.universidad.modelo.RegistroCurso;
import co.edu.eam.disenosoft.universidad.modelo.Estudiante;
import co.edu.eam.disenosoft.universidad.modelo.Evaluacion;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAOCurso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAOEstudiante;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAORegistroCurso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa.DAOCursoJPA;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa.DAOEstudianteJPA;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa.DAORegistroCurso;

public class BOCurso {
	private IDAOCurso dao;
	private IDAOEstudiante daoEstudiante;
	private IDAORegistroCurso daoRegistroCurso;
	public BOCurso() {
		dao = new DAOCursoJPA();
		daoEstudiante = new DAOEstudianteJPA();
		daoRegistroCurso = new DAORegistroCurso();
	}

	public void crear(Curso curso) throws Exception{
		dao.crear(curso);
	}

	public void editar(Curso curso) throws Exception{
		dao.editar(curso);
	}

	public Curso buscar(int codigo) throws Exception{
		Curso curso = dao.buscar(codigo);
		return curso;
	}

	public List<Curso> listarCursos() throws Exception{
		return dao.listarCursos();
	}
	
	public int sumaCreditosByAlumno(Estudiante estudiante) throws Exception{
		List<RegistroCurso> registros = daoRegistroCurso.registroCursosByAlumno(estudiante);
		int suma = 0;
		for(int i=0;i<registros.size();i++){
			suma += registros.get(i).getCurso().getAsignatura().getNumeroCreditos();
		}
		return suma;
	}

	public List<Curso> listaCursosByMateria(Asignatura asignatura) throws Exception{
		return dao.listaCursosByMateria(asignatura);
	}

	public void registrarCurso(RegistroCurso rc) throws Exception{
		int creditos = sumaCreditosByAlumno(rc.getEstudiante());
		int totalCreditos = creditos + rc.getCurso().getAsignatura().getNumeroCreditos();
			List<RegistroCurso> registrosCurso = daoRegistroCurso.listaRegistroCurso(rc.getCurso());
			if(!daoRegistroCurso.isRegistrada(rc)){
				if(registrosCurso.size() < 11){
					if(totalCreditos < 13){
						daoRegistroCurso.registrarCurso(rc);
					}else{
						throw new ExcepcionNegocio("Ha excedido el numero de creditos");
					}	
				}else{
					throw new ExcepcionNegocio("No hay cupos disponibles para este curso");
				}
			}else{
				throw new ExcepcionNegocio("Ya se encuentra Registrada esta materia");
			}
		
	}

	public RegistroCurso buscarRegistroCurso(Estudiante e, String codigo) throws Exception{
		return daoRegistroCurso.buscarRegistroCurso(e, codigo);
        }
	public void eliminarRegistroCurso(RegistroCurso rc) throws Exception{
		daoRegistroCurso.eliminarRegistroCurso(rc);
	}

	public List<RegistroCurso> registroCursosByAlumno(Estudiante estudiante) throws Exception{
		return daoRegistroCurso.registroCursosByAlumno(estudiante);
	}

	public void eliminarRegistroCursoEstudiante(RegistroCurso rc) throws Exception{
		if(rc.getNotas().size() == 0){
			daoRegistroCurso.eliminarRegistroCurso(rc);
		}else{
			throw new ExcepcionNegocio("No puedes eliminar este curso por que ya tienes calificaciones");
		}
	}

	public List<RegistroCurso> listaEstudiantesCurso(Curso curso) throws Exception{
		return daoRegistroCurso.listaRegistroCurso(curso);
	}

	public List<Curso> listaCursosByDocente(Docente d) throws Exception{
		return dao.listaCursosByDocente(d);
	}
	
	public List<Evaluacion> listaEvaluaciones(Curso cu) throws Exception {
		return dao.listaEvaluaciones(cu);
	}
}
