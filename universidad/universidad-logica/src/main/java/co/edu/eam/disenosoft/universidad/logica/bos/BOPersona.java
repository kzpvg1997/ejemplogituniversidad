
package co.edu.eam.disenosoft.universidad.logica.bos;
import co.edu.eam.disenosoft.universidad.logica.excepciones.ExcepcionNegocio;
import co.edu.eam.disenosoft.universidad.modelo.Persona;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAOPersona;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa.DAOPersonaJPA;

public class BOPersona {
	
	private IDAOPersona dao;
	public BOPersona() {
		dao = new DAOPersonaJPA();
	}

	public Persona buscar(String cedula) throws Exception{
		Persona p = dao.buscar(cedula);
		if(p!=null){
		return p;
		}else{
		throw new ExcepcionNegocio("Esta persona no existe");
		}
	}
}
	
