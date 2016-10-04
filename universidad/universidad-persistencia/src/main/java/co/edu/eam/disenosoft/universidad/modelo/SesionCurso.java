package co.edu.eam.disenosoft.universidad.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import co.edu.eam.disenosoft.universidad.modelo.enumeraciones.DiaEnum;


@NamedQueries({
	@NamedQuery(name=SesionCurso.SESIONES_POR_CURSO,
			query="SELECT sc FROM SesionCurso sc WHERE sc.curso=?1")
	})
@Entity
@Table(name="tb_sesioncurso")
public class SesionCurso implements Serializable{
	/* Constantes de consultas */
	/**
	 * ?1 el codigo del curso 
	 */
	public static final String SESIONES_POR_CURSO = "Curso.Sesiones";
	
	/* Identificador de la sesion curso*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	/**
	 * Dia de la sesion.
	 */
	@Column(name="dia_sesion", nullable=false, length=255)
	@Enumerated(EnumType.STRING)
	private DiaEnum dia;
	
	/**
	 * Hora en que termina la sesion.
	 */
	@Column(name="horafinal_sesion",nullable=false)
	private int horaFinal;
	
	/**
	 * Hora en que empieza una sesion.
	 */
	@Column(name="horainicio_sesion",nullable=false)
	private int horaInicio;
	
	/**
	 * Curso de la sesion.
	 */
	@ManyToOne
	@JoinColumn(name="codigo_curso")
	private Curso curso;

	/**
	 * Cosntructor.
	 */
	public SesionCurso() {
		super();
	}

	public SesionCurso(int id, DiaEnum dia, int horaFinal, int horaInicio, Curso curso) {
		super();
		this.id = id;
		this.dia = dia;
		this.horaFinal = horaFinal;
		this.horaInicio = horaInicio;
		this.curso = curso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DiaEnum getDia() {
		return dia;
	}

	public void setDia(DiaEnum dia) {
		this.dia = dia;
	}

	public int getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(int horaFinal) {
		this.horaFinal = horaFinal;
	}

	public int getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
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
		SesionCurso other = (SesionCurso) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return dia+" de "+horaInicio+" a "+horaFinal;
	}
	

}
