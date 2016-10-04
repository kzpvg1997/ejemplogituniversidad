/**
 * 
 */
package co.edu.eam.disenosoft.universidad.logica.bos;

import java.util.List;

import javax.swing.JOptionPane;

import co.edu.eam.disenosoft.universidad.logica.excepciones.ExcepcionNegocio;
import co.edu.eam.disenosoft.universidad.modelo.Curso;
import co.edu.eam.disenosoft.universidad.modelo.Estudiante;
import co.edu.eam.disenosoft.universidad.modelo.Evaluacion;
import co.edu.eam.disenosoft.universidad.modelo.Nota;
import co.edu.eam.disenosoft.universidad.modelo.RegistroCurso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jdbc.DAONotaJDBC;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa.DAONotaJPA;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa.DAORegistroCurso;

/**
 * @author TOSHIBAP55W
 *
 */
public class BONota {

	private DAONotaJPA daoNota;
	private DAONotaJDBC daoNotaJDBC;
	private DAORegistroCurso daoRegCur;
	
	public BONota(){
		daoNota = new DAONotaJPA() ;
		daoNotaJDBC = new DAONotaJDBC();
		daoRegCur = new DAORegistroCurso();
	}
	
	public void crearNota (Nota nota)throws Exception{
		
		daoNota.crearNota(nota);
	}
	
	public List<Nota> verificarEditada (Nota nota)throws Exception{
		
		return daoNota.consultaEditada(nota);
	}
	
	public List<Nota> notaByEstudiante(Estudiante estudiante) throws Exception {
		return daoNota.notaByEstudiante(estudiante);
	}
//	public void editarNota(Nota nota) throws Exception {
//		daoNota.editarNota(nota);
//	}
	
	public Nota buscarNota(Estudiante es) throws Exception {
		return daoNota.buscarNota(es);
	}
	
	public boolean verificarEdicionNota(Nota nota) throws Exception{
		
		List<Nota> notas = daoNota.consultaEditada(nota);
		boolean editado = false;
		for (int i = 0; i <notas.size(); i++) {
			
		System.out.println(notas);
			
			if(notas.get(i).isEditada()==editado){
				editado = true;
				System.out.println("No esta editado");
				
				
			}else{
				editado = false;
				System.out.println("esta esditado");
			}
			
		}
		return editado;
	}
	public void registrarNota(RegistroCurso rc, Nota nota,Evaluacion evaluacion) throws Exception{
		List<Nota> notas = rc.getNotas();
		String msj = null;
		for (Nota n : notas) {
			
			if(n.getEvaluacion().getId()==evaluacion.getId()){
				msj = "Esta nota ya esta registrada";
				throw new ExcepcionNegocio("Esta nota ya esta registrada");
					
			} 
		}
		if(msj == null){ 
			rc.getNotas().add(nota);
			daoRegCur.editar(rc);
			
			
		}else{
			throw new ExcepcionNegocio(msj);
		}
		
	}
	
	public void editarNota(RegistroCurso rc, Nota nota,Evaluacion evaluacion) throws Exception{
		List<Nota> notas = rc.getNotas();
		String msj = null;
		for (Nota n : notas) {
			
			if(n.isEditada() ==true && nota.isEditada()==true && n.getId() == nota.getId()){
				msj = "Esta nota ya esta editada";
				throw new ExcepcionNegocio("Esta nota ya esta editada");
					
			} 
		}
		if(msj == null){ 
			
			daoNota.editarNota(nota);
			nota.setEditada(true);
			//daoRegCur.editar(rc);
			rc.getNotas().add(nota);
			
			
			
		}else{
			throw new ExcepcionNegocio(msj);
		}
		
	}
}
