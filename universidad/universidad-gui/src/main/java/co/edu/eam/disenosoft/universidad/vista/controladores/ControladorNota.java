/**
 * 
 */
package co.edu.eam.disenosoft.universidad.vista.controladores;

import java.util.List;

import co.edu.eam.disenosoft.universidad.logica.bos.BONota;
import co.edu.eam.disenosoft.universidad.modelo.Curso;
import co.edu.eam.disenosoft.universidad.modelo.Estudiante;
import co.edu.eam.disenosoft.universidad.modelo.Evaluacion;
import co.edu.eam.disenosoft.universidad.modelo.Nota;
import co.edu.eam.disenosoft.universidad.modelo.RegistroCurso;

/**
 * @author TOSHIBAP55W
 *
 */
public class ControladorNota {

	private BONota boNota;

	public ControladorNota() {
		boNota = new BONota();
	}

	public void crearNota(Nota nota) throws Exception {
		boNota.crearNota(nota);
	}

//	public List<Nota> verificarEditada(Nota nota) throws Exception {
//
//		return boNota.verificarEditada(nota);
//	}

	public List<Nota> notaByEstudiante(Estudiante estudiante) throws Exception {
		return boNota.notaByEstudiante(estudiante);
	}
//	public void editarNota(Nota nota) throws Exception {
//		boNota.editarNota(nota);
//	}
	public Nota buscarNota(Estudiante es) throws Exception {
		return boNota.buscarNota(es);
	}
	
	public boolean verificarEditada(Nota nota) throws Exception{
		return boNota.verificarEdicionNota(nota);
	}
	public void registrarNota(RegistroCurso rc, Nota nota , Evaluacion evaluacion) throws Exception{
		boNota.registrarNota(rc, nota, evaluacion);
	}
	
	public void editarNota(RegistroCurso rc, Nota nota,Evaluacion evaluacion) throws Exception{
		boNota.editarNota(rc, nota, evaluacion);
	}
}
