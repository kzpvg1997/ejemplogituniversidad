package co.edu.eam.disenosoft.universidad.logica.bos;
import java.util.List;

import co.edu.eam.disenosoft.universidad.modelo.Docente;
import co.edu.eam.disenosoft.universidad.modelo.Profesion;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAODocente;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAOProfesion;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa.DAODocenteJPA;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa.DAOProfesionJPA;

public class BODocente {
	
	private IDAODocente daoDocente;
	public BODocente() {
		daoDocente = new DAODocenteJPA();
	}
	
	public void crear(Docente docente) throws Exception{
		daoDocente.crear(docente);
	}
	public void editar(Docente docente) throws Exception{
		daoDocente.editar(docente);
	}
	public void eliminar(String cedula) throws Exception{
		daoDocente.eliminar(cedula);
	}
	public Docente buscar(String cedula) throws Exception{
		Docente docente = daoDocente.buscar(cedula);
		return docente;
	}
	public List<Profesion> listarTodosProfesiones() throws Exception{
		IDAOProfesion daoProfesion = new DAOProfesionJPA();
		return daoProfesion.listarTodos();
	}
}
