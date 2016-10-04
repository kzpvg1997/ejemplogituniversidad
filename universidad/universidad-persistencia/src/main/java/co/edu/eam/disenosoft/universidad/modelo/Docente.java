package co.edu.eam.disenosoft.universidad.modelo;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_docente")
public class Docente extends Persona {	
	/* indica si el docente tiene postgrado. */
	@Column(name="postgrado_doc")
	private boolean postgrado; 
	
	/* Profesion del docente. */
	@ManyToOne(cascade = {})
	@JoinColumn(name="profesion_doc")
	private Profesion profesion;	
	
	/* Cursos que imparte el docente. */
	@OneToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL,mappedBy="docente")
	private List<Curso> cursos; 
	
	/* Constructor */
	public Docente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Docente(String cedula, String apellido, String correo, String direccion, String nombre, String telefono, boolean postgrado, Profesion profesion) {
		super(cedula, apellido, correo, direccion, nombre, telefono);
		this.postgrado = postgrado;
		this.profesion = profesion;
	}


	/**
	 * @return the profesion
	 */
	public Profesion getProfesion() {
		return profesion;
	}

	/**
	 * @param profesion
	 * the profesion to set
	 */
	public void setProfesion(Profesion profesion) {
		this.profesion = profesion;
	}

	/**
	 * @return the postgrado
	 */
	public boolean isPostgrado() {
		return postgrado;
	}

	/**
	 * @param postgrado
	 *            the postgrado to set
	 */
	public void setPostgrado(boolean postgrado) {
		this.postgrado = postgrado;
	}

//	/**
//	 * @return the cursos
//	 */
//	public List<Curso> getCursos() {
//		return cursos;
//	}
//
//	/**
//	 * @param cursos the cursos to set
//	 */
//	public void setCursos(List<Curso> cursos) {
//		this.cursos = cursos;
//	}

}
