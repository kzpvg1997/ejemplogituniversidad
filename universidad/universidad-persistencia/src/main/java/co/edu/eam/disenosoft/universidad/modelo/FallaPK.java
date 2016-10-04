package co.edu.eam.disenosoft.universidad.modelo;
import java.io.Serializable;

public class FallaPK implements Serializable{
	private int id;
	private RegistroCurso curso;

	public FallaPK() {
		super();
	}

	public FallaPK(int id, RegistroCurso curso) {
		super();
		this.id = id;
		this.curso = curso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
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
		FallaPK other = (FallaPK) obj;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
}
