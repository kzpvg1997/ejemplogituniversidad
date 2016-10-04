
package co.edu.eam.disenosoft.universidad.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@NamedQueries({
	@NamedQuery(name=Evaluacion.EVALUACIONES_CURSO,query="SELECT e FROM Evaluacion e WHERE e.curso=?1"),
	@NamedQuery(name=Evaluacion.CONSULTA_ID_EVALUACION,query="SELECT e.id FROM Evaluacion e")
})
@Entity
@Table(name="tb_evaluacion")
public class Evaluacion implements Serializable{

	public static final String EVALUACIONES_CURSO = "Evaluacion.evaluacionesCurso";
	
	public static final String CONSULTA_ID_EVALUACION ="Evaluacion.idEvaluacion";
	
	/* Identificador de la evaluacion*/
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	/* Nombre de la evaluacion */
	@Column(name="nombre_eval", nullable=false,length=50)
	private String nombre;
	
	/* Porcentaje que vale esta evaluacion dentro del curso. */
	@Column(name="porcentaje_eval",nullable=false)
	private double porcentaje;
	
	/* Curso al que pertenece esta evaluacion. */
	@ManyToOne
	@JoinColumn(name="codigo_cur")
	private Curso curso;

	public Evaluacion() {
	}

	public Evaluacion(String nombre, double porcentaje, Curso curso) {
		super();
		this.nombre = nombre;
		this.porcentaje = porcentaje;
		this.curso = curso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
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
		Evaluacion other = (Evaluacion) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return nombre;
	}

	
	
}
