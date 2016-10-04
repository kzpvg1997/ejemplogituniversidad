
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
import javax.persistence.Table;

@Entity
@Table(name="tb_falla")
@IdClass(FallaPK.class)
public class Falla implements Serializable
{
	/* Identificador de una falla */ 
	@Id
	@Column(name="id_falla")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	/* Numero de fallas */ 
	@Column(name="numero_fallas", nullable=false)
	private int numero;
	
	/* Curso al que pertenece la falla */
	@Id
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="codigo_cur",referencedColumnName="codigo_cur"),
		@JoinColumn(name="cedula_est",referencedColumnName="cedula_est")	
	})
	private RegistroCurso curso;

	public Falla() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Falla(int id, int numero, RegistroCurso curso) {
		super();
		this.id = id;
		this.numero = numero;
		this.curso = curso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public RegistroCurso getCurso() {
		return curso;
	}

	public void setCurso(RegistroCurso curso) {
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
		Falla other = (Falla) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Falla [id=" + id + ", numero=" + numero + ", curso=" + curso + "]";
	}

	
	
	
}
