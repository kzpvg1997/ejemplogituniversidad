package co.edu.eam.disenosoft.universidad.vista.controladores;
import java.util.List;
import co.edu.eam.disenosoft.universidad.logica.bos.BOEstudiante;
import co.edu.eam.disenosoft.universidad.logica.bos.BOPersona;
import co.edu.eam.disenosoft.universidad.modelo.Estudiante;
import co.edu.eam.disenosoft.universidad.modelo.Persona;

public class ControladorAdminEstudiante {
	
	private BOEstudiante bo;	
	private BOPersona boPersona;
	public ControladorAdminEstudiante() {
		bo = new BOEstudiante();
		boPersona = new BOPersona();
	}
	public void crear(Estudiante estudiante) throws Exception{
		bo.crear(estudiante);
	}

	public void editar(Estudiante estudiante) throws Exception{
		bo.editar(estudiante);
	}

	public void eliminar(String cedula) throws Exception{
		bo.eliminar(cedula);
	}

	public Estudiante buscar(String cedula) throws Exception{
		return bo.buscar(cedula);
	}

	public Persona buscarPersona(String cedula) throws Exception{
		return boPersona.buscar(cedula);
	}
}
