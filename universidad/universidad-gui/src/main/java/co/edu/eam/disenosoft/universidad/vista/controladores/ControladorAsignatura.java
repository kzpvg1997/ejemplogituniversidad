
package co.edu.eam.disenosoft.universidad.vista.controladores;

import java.util.List;

import co.edu.eam.disenosoft.universidad.logica.bos.BOAsignatura;
import co.edu.eam.disenosoft.universidad.modelo.Asignatura;
public class ControladorAsignatura {
	
	private BOAsignatura bo;
	public ControladorAsignatura() {
		bo = new BOAsignatura();
	}
	
	public void crear(Asignatura asignatura) throws Exception{
		bo.crear(asignatura);
	}
	public void editar(Asignatura asignatura) throws Exception{
		bo.editar(asignatura);
	}
	public void eliminar(String codigo) throws Exception{
		bo.eliminar(codigo);
	}
	public Asignatura buscar(String codigo) throws Exception{
		return bo.buscar(codigo);
	}
}
