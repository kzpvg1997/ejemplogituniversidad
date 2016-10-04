package co.edu.eam.disenosoft.universidad.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_profesion")
public class Profesion implements Serializable{
	
	@Id
	@Column(name="codigo_prof", length=50)
	private String codigo; // codigo de la profesion.
	
	@Column(name="nombre_prof", nullable=false, length=50)
	private String nombre; // Nombre de la profesion.
	
	/* COnstructor */
	public Profesion() {
		super();
	}

	/**
	 * @param codigo
	 * @param nombre
	 */
	public Profesion(String codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Profesion other = (Profesion) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return nombre;
	}


	
}
