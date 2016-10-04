
package co.edu.eam.disenosoft.universidad.vista.controladores;

import java.util.List;

import co.edu.eam.disenosoft.universidad.logica.bos.BOCurso;
import co.edu.eam.disenosoft.universidad.logica.bos.BOEstudiante;
import co.edu.eam.disenosoft.universidad.modelo.Estudiante;
import co.edu.eam.disenosoft.universidad.modelo.RegistroCurso;

public class ControladorVerRegistroEstudiante {
	
	private BOEstudiante boEstudiante;
	private BOCurso boCurso;
	public ControladorVerRegistroEstudiante() {
		boEstudiante = new BOEstudiante();
		boCurso = new BOCurso();
	}

	public Estudiante buscarEstudiante(String cedula) throws Exception{
		return boEstudiante.buscar(cedula);
	}	

	public int sumaCreditosByAlumno(Estudiante estudiante) throws Exception{
		return boCurso.sumaCreditosByAlumno(estudiante);
	}

	public List<RegistroCurso> registroCursosByAlumno(Estudiante estudiante) throws Exception{
		return boCurso.registroCursosByAlumno(estudiante);
	}

	public void eliminarRegistroCurso(RegistroCurso rc) throws Exception{
		boCurso.eliminarRegistroCursoEstudiante(rc);
	}
}
