package co.edu.eam.disenosoft.universidad.modelo;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
/**
 * Clase que representa una Persona.
 * @author Carlos Alfredo Martinez Villada
 */
@Entity
@Table(name="tb_persona")
@Inheritance(strategy=InheritanceType.JOINED)
public class Persona implements Serializable {
	
	@Id
	@Column(name="cedula_per",nullable=false)
	protected String cedula; // Cedula de la persona.
	
	@Column(name="apellido_per",nullable=false, length=50)
	protected String apellido; // Apellido de la persona
		
	@Column(name="correo_per",nullable=false, length=50)
	protected String correo; // Correo de la persona.
	
	@Column(name="direccion_per",nullable=false, length=255)
	protected String direccion; // Direccion de la persona
	
	@Column(name="nombre_per",nullable=false, length=50)
	protected String nombre; // Nombre de la persona.
	
	@Column(name="telefono_per",nullable=false, length=50)
	protected String telefono; // Telefono de la persona.

	/**
	 * COsntructor.
	 */
	public Persona() {
		super();
	}

	public Persona(String cedula, String apellido, String correo, String direccion, String nombre, String telefono) {
		super();
		this.cedula = cedula;
		this.apellido = apellido;
		this.correo = correo;
		this.direccion = direccion;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cedula == null) ? 0 : cedula.hashCode());
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
		Persona other = (Persona) obj;
		if (cedula == null) {
			if (other.cedula != null)
				return false;
		} else if (!cedula.equals(other.cedula))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Persona [cedula=" + cedula + ", apellido=" + apellido + ", correo=" + correo + ", direccion="
				+ direccion + ", nombre=" + nombre + ", telefono=" + telefono + "]";
	}
	
}
