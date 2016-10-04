
package co.edu.eam.disenosoft.universidad.logica.bos;

import co.edu.eam.disenosoft.universidad.modelo.Estudiante;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAOEstudiante;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa.DAOEstudianteJPA;

public class BOEstudiante {
	private IDAOEstudiante dao;

	public BOEstudiante() {
		dao = new DAOEstudianteJPA();
	}

	public void crear(Estudiante estudiante) throws Exception{
		dao.crear(estudiante);
	}

	public void editar(Estudiante estudiante) throws Exception{
		dao.editar(estudiante);
	}

	public void eliminar(String cedula) throws Exception{
		dao.eliminar(cedula);
	}

	public Estudiante buscar(String cedula) throws Exception{
		Estudiante estudiante = dao.buscar(cedula);
		return estudiante;
	}
	
}
