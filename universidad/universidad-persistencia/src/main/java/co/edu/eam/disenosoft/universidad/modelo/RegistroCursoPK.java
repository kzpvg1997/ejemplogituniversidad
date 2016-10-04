package co.edu.eam.disenosoft.universidad.modelo;

import java.io.Serializable;

public class RegistroCursoPK implements Serializable{
	private String estudiante;
	private int curso;
	
	public RegistroCursoPK() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegistroCursoPK(String estudiante, int curso) {
		super();
		this.estudiante = estudiante;
		this.curso = curso;
	}

	public String getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(String estudiante) {
		this.estudiante = estudiante;
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + curso;
		result = prime * result + ((estudiante == null) ? 0 : estudiante.hashCode());
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
		RegistroCursoPK other = (RegistroCursoPK) obj;
		if (curso != other.curso)
			return false;
		if (estudiante == null) {
			if (other.estudiante != null)
				return false;
		} else if (!estudiante.equals(other.estudiante))
			return false;
		return true;
	}	
}
