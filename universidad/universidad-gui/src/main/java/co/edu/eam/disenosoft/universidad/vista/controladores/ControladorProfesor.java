
package co.edu.eam.disenosoft.universidad.vista.controladores;
import java.util.List;

import co.edu.eam.disenosoft.universidad.logica.bos.BODocente;
import co.edu.eam.disenosoft.universidad.logica.bos.BOPersona;
import co.edu.eam.disenosoft.universidad.modelo.Docente;
import co.edu.eam.disenosoft.universidad.modelo.Persona;
import co.edu.eam.disenosoft.universidad.modelo.Profesion;

public class ControladorProfesor {
	
	private BODocente bo;
	private BOPersona boPersona;
	public ControladorProfesor() {
		bo = new BODocente();
		boPersona = new BOPersona();
	}

	public void crear(Docente docente) throws Exception{
		bo.crear(docente);
	}

	public void editar(Docente docente) throws Exception{
		bo.editar(docente);
	}
	public void eliminar(String cedula) throws Exception{
		bo.eliminar(cedula);
	}
	public Docente buscar(String cedula) throws Exception{
		return bo.buscar(cedula);
	}
	public List<Profesion> listarTodosProfesiones() throws Exception{
		return bo.listarTodosProfesiones();
	}
	public Persona buscarPersona(String cedula) throws Exception{
		return boPersona.buscar(cedula);
	}
}
