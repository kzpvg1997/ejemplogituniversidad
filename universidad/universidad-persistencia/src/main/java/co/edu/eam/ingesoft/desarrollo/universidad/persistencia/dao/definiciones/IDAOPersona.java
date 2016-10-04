
package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones;
import co.edu.eam.disenosoft.universidad.modelo.Persona;

public interface IDAOPersona {

	public Persona buscar(String cedula) throws Exception;
}
