
package co.edu.eam.disenosoft.universidad.logica.bos;
import java.sql.SQLException;
import java.util.List;
import co.edu.eam.disenosoft.universidad.modelo.SesionCurso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAOCurso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAODocente;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAOSesionCurso;
import co.edu.eam.disenosoft.universidad.logica.excepciones.ExcepcionNegocio;
import co.edu.eam.disenosoft.universidad.modelo.Curso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jdbc.DAOSesionCursoJDBC;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa.DAOCursoJPA;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa.DAODocenteJPA;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa.DAOSesionCursoJPA;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.utilidades.AdministradorEntityManager;
import co.edu.eam.disenosoft.universidad.modelo.Curso;

public class BOSesionCurso {

	private IDAOSesionCurso daoSesion;
	private IDAODocente daoDocente;
	private IDAOCurso daoCurso;
	private IDAOSesionCurso daoSesionJDBC;

	public BOSesionCurso() {

		daoSesion = new DAOSesionCursoJPA();
		daoDocente = new DAODocenteJPA();
		daoCurso = new DAOCursoJPA();
		daoSesionJDBC = new DAOSesionCursoJDBC();
	}

	public void crearSesion(SesionCurso sesion) throws Exception {

		
		 boolean verificarhorario = daoSesionJDBC.consultaExistente(sesion.getDia(),
							sesion.getHoraInicio(), sesion.getHoraFinal(),
							sesion.getCurso().getCodigo(),sesion.getCurso().getDocente().getCedula());

					if (verificarhorario) {
						if(sesion.getHoraInicio()>sesion.getHoraFinal()){
							throw new ExcepcionNegocio("La hora final no puede ser menor a la hora inicial del horario");
						}else{
							daoSesion.crear(sesion);
							daoSesion.listarSesionesByCurso(sesion.getCurso());
						}
						
					} else {
						
						throw new ExcepcionNegocio("Este horario ya esta asignado a este docente o esta intercalado");
					}

				}

			

	

	public SesionCurso buscarSesionCurso(int id) throws Exception {

		SesionCurso sesionC = daoSesion.buscar(id);
		if (sesionC != null) {
			throw new ExcepcionNegocio("ya existe esta sesion de curso cambie el ID de horario");
		} else {
			return sesionC;
		}
	}

	public List<SesionCurso> listarSesionesCurso(Curso curso) throws Exception {

		Curso cur = daoCurso.buscar(curso.getCodigo());
		if (cur != null) {
			List<SesionCurso> sesiones = daoSesion.listarSesionesByCurso(curso);
			return sesiones;
		} else {

			throw new ExcepcionNegocio("Este curso no existe");
		}

	}

	public void eliminarSesionCurso(int id) throws Exception {

		SesionCurso sesionC = daoSesion.buscar(id);
		if (sesionC != null) {
			daoSesion.eliminar(id);
		} else {

			throw new ExcepcionNegocio("Esta sesion no Existe");
		}

	}

	public void editar(SesionCurso sesion) throws Exception {
		daoSesion.editar(sesion);		
	}
	
	public void crearCurso(Curso curso)throws Exception{
		daoCurso.crear(curso);
	}
	
	public Curso buscarCurso(int codigo)throws Exception{
		
		return daoCurso.buscar(codigo);
	}
	
	public void editarCurso(Curso curso)throws Exception{
		
		daoCurso.editar(curso);
	}

}
