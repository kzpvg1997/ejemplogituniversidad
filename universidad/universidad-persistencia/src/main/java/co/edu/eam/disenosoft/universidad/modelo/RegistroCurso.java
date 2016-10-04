package co.edu.eam.disenosoft.universidad.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name=RegistroCurso.CURSOS_REGISTRADOS,query="SELECT rc FROM RegistroCurso rc WHERE rc.estudiante=?1"),
	@NamedQuery(name=RegistroCurso.LISTA_CURSOS_REGISTRADOS,query="SELECT rc FROM RegistroCurso rc WHERE rc.curso=?1")

})
@Entity
@IdClass(RegistroCursoPK.class)
@Table(name="tb_registrocurso")
public class RegistroCurso implements Serializable {
	/**
	 * ?1: El curso
	 */
	public static final String CURSOS_REGISTRADOS = "RegistroCurso.cursosRegistrados";

	/**
	 * ?1: El curso
	 */
	public static final String LISTA_CURSOS_REGISTRADOS = "RegistroCurso.listaCursosRegistrados";
	
	/**
	 * Curso que registro el estudiante.
	 */
	@Id
	@ManyToOne(cascade = {})
	@JoinColumn(name="codigo_cur")
	private Curso curso;

	/* Estudiante que registro el curso. */
	@Id
	@ManyToOne(cascade = {})
	@JoinColumn(name="cedula_est")
	private Estudiante estudiante;
	
	/**
	 * Notas que el estudiante tiene registradas en este curso.
	 */
	@OneToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL,mappedBy="registroCurso",orphanRemoval=true)
	private List<Nota> notas;

	public RegistroCurso() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param estudiante
	 * @param curso
	 * @param notas
	 */
	public RegistroCurso(Estudiante estudiante, Curso curso) {
		super();
		this.estudiante = estudiante;
		this.curso = curso;
	}

	/**
	 * @return the estudiante
	 */
	public Estudiante getEstudiante() {
		return estudiante;
	}

	/**
	 * @param estudiante
	 *            the estudiante to set
	 */
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	/**
	 * @return the curso
	 */
	public Curso getCurso() {
		return curso;
	}

	/**
	 * @param curso
	 *            the curso to set
	 */
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	/**
	 * @return the notas
	 */
	public List<Nota> getNotas() {
		return notas;
	}

	/**
	 * @param notas
	 *            the notas to set
	 */
	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

}
