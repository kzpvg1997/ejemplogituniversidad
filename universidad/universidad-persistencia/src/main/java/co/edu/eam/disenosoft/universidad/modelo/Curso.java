package co.edu.eam.disenosoft.universidad.modelo;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@NamedQueries({
	@NamedQuery(name=Curso.CURSOS_MATERIA,query="SELECT c FROM Curso c WHERE c.asignatura=?1"),
	@NamedQuery(name=Curso.CURSOS_DOCENTE,query="SELECT c FROM Curso c WHERE c.docente=?1"),
	@NamedQuery(name=Curso.EVALUACIONES_PORCURSO,query="SELECT c.evaluacion.id FROM Nota c JOIN c.registroCurso rc WHERE rc.curso.codigo=?1")
})
@Entity
@Table(name="tb_curso")
public class Curso implements Serializable {

	/**
	 * ?1: El curso
	 */
	public static final String CURSOS_MATERIA = "Curso.cursosMateria";
	
	/**
	 * consulta para listar todos los cursos de un docente
	 * ?1: El curso
	 */
	public static final String CURSOS_DOCENTE = "Curso.cursosDocente";
	/**
	 * Consulta para las evaluaciones que teine un curso
	 * ?1codigo curso
	 */
	public static final String EVALUACIONES_PORCURSO = "Curso.evaluacionesCurso";
	
	
	
	
	/* Codigo que identifica al curso */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_curso")
	private int codigo;

	/* Asignatura de este curso */
	@ManyToOne(cascade = {})
	@JoinColumn(name="codigo_asignatura", nullable=false)
	private Asignatura asignatura;
	
	/* Docente que imparte la asignatura. */
	@ManyToOne(cascade = {})
	@JoinColumn(name="cedula_docente")
	private Docente docente;


	@OneToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL,mappedBy="curso")
	private List<SesionCurso> sesiones;
	

	@OneToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL,mappedBy="curso")
	private List<RegistroCurso> estudiantes;

	@OneToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL,mappedBy="curso")
	private List<Evaluacion> evaluaciones;
	

	public Curso() {
		super();
	}
	
	/**
	 * Constructor.
	 * 
	 * @param codigo
	 * @param docente
	 * @param asignatura
	 */
	public Curso(int codigo, Docente docente, Asignatura asignatura) {
		super();
		this.codigo = codigo;
		this.docente = docente;
		this.asignatura = asignatura;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public List<SesionCurso> getSesiones() {
		return sesiones;
	}

	public void setSesiones(List<SesionCurso> sesiones) {
		this.sesiones = sesiones;
	}

	public List<RegistroCurso> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<RegistroCurso> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public List<Evaluacion> getEvaluaciones() {
		return evaluaciones;
	}

	public void setEvaluaciones(List<Evaluacion> evaluaciones) {
		this.evaluaciones = evaluaciones;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ""+codigo+"" ;
	}


}
