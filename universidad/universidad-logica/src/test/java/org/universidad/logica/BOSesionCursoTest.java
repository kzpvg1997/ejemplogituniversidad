/**
 * 
 */
package org.universidad.logica;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import co.edu.eam.disenosoft.universidad.logica.bos.BOAsignatura;
import co.edu.eam.disenosoft.universidad.logica.bos.BOCurso;
import co.edu.eam.disenosoft.universidad.logica.bos.BODocente;
import co.edu.eam.disenosoft.universidad.logica.bos.BOSesionCurso;
import co.edu.eam.disenosoft.universidad.modelo.Asignatura;
import co.edu.eam.disenosoft.universidad.modelo.Curso;
import co.edu.eam.disenosoft.universidad.modelo.Docente;

/**
 * @author TOSHIBAP55W
 *
 */
public class BOSesionCursoTest {
	
	private BOCurso boCurso;
	private BOAsignatura boAsig;
	private BODocente boDocente;
	
	@Before
	public void  setUp(){
		
		boCurso = new BOCurso();
		boAsig = new BOAsignatura();
		boDocente = new BODocente();
	}
	@Test
	public void testearCurso()throws Exception {
		
		Curso curso = new Curso();
		
		Asignatura asi = boAsig.buscar("1234");
		Docente doc = boDocente.buscar("123");
		
		curso.setAsignatura(asi);
		curso.setDocente(doc);
		
		try{
		boCurso.crear(curso);
		
		Curso accBuscado  =boCurso.buscar(12);
		
		Assert.assertNotNull(accBuscado);
		Assert.assertEquals("123", accBuscado.getDocente().getCedula());
		
		}catch(Exception e){
			Assert.fail();
		}
	}
}
