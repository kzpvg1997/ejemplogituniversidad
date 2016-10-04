/**
 * 
 */
package co.edu.eam.disenosoft.universidad.modelo;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Clase que representa una calificacion de una evaluacion de un curso.
 * @author Carlos Martinez.
 */
@NamedQueries({
	@NamedQuery(name=Nota.NOTAS_EVALUACION,query="SELECT n FROM Nota n WHERE n.evaluacion=?1"),
	@NamedQuery(name=Nota.CONSULTA_EDITADA,query="SELECT n.editada FROM Nota n"),
	@NamedQuery(name=Nota.CONSULTA_CALIFICACION,query="SELECT n.valor FROM Nota n JOIN n.registroCurso rc  WHERE rc.curso=?1"),
	@NamedQuery(name=Nota.CONSULTA_ID_NOTA , query="SELECT n.id FROM Nota n"),
	@NamedQuery(name=Nota.CONSULTA_NOTA_CURSO , query="SELECT n FROM Nota n JOIN n.registroCurso rc where rc.estudiante=?1")
})
@Entity
@Table(name="tb_nota")
//@IdClass(NotaPK.class)
public class Nota implements Serializable {
	/**
	 * consulta para listar todas las notas de una determinada evaluacion
	 * ?1: El curso
	 */
	public static final String NOTAS_EVALUACION = "Nota.notasEvaluacion";
	/**
	 * consulta para determinar si una consulta esta editada o no
	 */
	public static final String CONSULTA_EDITADA = "Nota.consultaEditada";
	/**
	 * consulta para determinar la calificacion de un estudiante
	 */
	public static final String CONSULTA_CALIFICACION = "Nota.consultaCalificacion";
	
	
	public static final String CONSULTA_ID_NOTA = "Nota.consultaIdNota";
	
	
	public static final String CONSULTA_NOTA_CURSO = "Nota.consultaNotaCurso";
	
	/* identificador */
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	/**
	 *  bandera que indica si la nota ya fue modificada para no dejar que lo sea una vez mas. 
	 *  true = modificada 
	 *  false = No modificada
	 */
	@Column(name="editada_nota", nullable=false)
	private boolean editada;
	
	/* Nota que puso el profesor. */
	@Column(name="valor_nota", nullable=false)
	private double valor;
	
	/* Evaluacion a la que pertenece esta nota. */
	@ManyToOne(cascade = {})
	@JoinColumn(name="id_evaluacion")
	private Evaluacion evaluacion;	
	

	/* Curso y estudiante al que pertenece esta nota. */
	//@Id
	@ManyToOne(cascade = {})
	@JoinColumns({
		@JoinColumn(name="codigo_cur", referencedColumnName="codigo_cur"),
		@JoinColumn(name="cedula_est", referencedColumnName="cedula_est")
	})
	private RegistroCurso registroCurso;
	/**
	 * Constructor
	 */
	public Nota() {
	}
	public Nota( boolean editada, double valor, Evaluacion evaluacion, RegistroCurso registroCurso) {
		super();
		this.editada = editada;
		this.valor = valor;
		this.evaluacion = evaluacion;
		this.registroCurso = registroCurso;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isEditada() {
		return editada;
	}
	public void setEditada(boolean editada) {
		this.editada = editada;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Evaluacion getEvaluacion() {
		return evaluacion;
	}
	public void setEvaluacion(Evaluacion evaluacion) {
		this.evaluacion = evaluacion;
	}
	public RegistroCurso getRegistroCurso() {
		return registroCurso;
	}
	public void setRegistroCurso(RegistroCurso registroCurso) {
		this.registroCurso = registroCurso;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Nota other = (Nota) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Nota [valor=" + valor + "]";
	}


}
