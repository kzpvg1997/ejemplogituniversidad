/**
 * 
 */
package co.edu.eam.disenosoft.universidad.modelo;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="tb_Estudiante")
public class Estudiante extends Persona {
	

	/* Fecha nacimiento estudiante. */
	@Column(name="fechanacimiento_est")
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	/* Cursos registrados por el estudiante. */
	@OneToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL,mappedBy="estudiante")
	private List<RegistroCurso> registro;

	public Estudiante() {
	}

	public Estudiante(String cedula, String apellido, String correo, String direccion, String nombre, String telefono, Date fechaNacimiento) {
		super(cedula, apellido, correo, direccion, nombre, telefono);
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public List<RegistroCurso> getRegistro() {
		return registro;
	}

	public void setRegistro(List<RegistroCurso> registro) {
		this.registro = registro;
	}
	
}
