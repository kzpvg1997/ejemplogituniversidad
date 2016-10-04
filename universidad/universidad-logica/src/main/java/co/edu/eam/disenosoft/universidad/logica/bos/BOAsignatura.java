
package co.edu.eam.disenosoft.universidad.logica.bos;
import co.edu.eam.disenosoft.universidad.modelo.Asignatura;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAOAsignatura;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa.DAOAsignaturaJPA;

public class BOAsignatura {

	private IDAOAsignatura dao;

	public BOAsignatura() {
		dao = new DAOAsignaturaJPA();
	}

	public void crear(Asignatura asignatura) throws Exception{
		dao.crear(asignatura);
	}

	public void editar(Asignatura asignatura) throws Exception{
		dao.editar(asignatura);
	}

	public void eliminar(String codigo) throws Exception{
		dao.eliminar(codigo);
	}

	public Asignatura buscar(String codigo) throws Exception{
		Asignatura asignatura = dao.buscar(codigo);
		return asignatura;
	}
}
