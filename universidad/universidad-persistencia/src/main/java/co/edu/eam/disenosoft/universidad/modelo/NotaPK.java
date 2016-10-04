package co.edu.eam.disenosoft.universidad.modelo;

import java.io.Serializable;

public class NotaPK implements Serializable{
	private int id;
	private RegistroCurso registroCurso;
	
	public NotaPK() {
	}

	public NotaPK(int id, RegistroCurso registroCurso) {
		super();
		this.id = id;
		this.registroCurso = registroCurso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		result = prime * result + ((registroCurso == null) ? 0 : registroCurso.hashCode());
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
		NotaPK other = (NotaPK) obj;
		if (id != other.id)
			return false;
		if (registroCurso == null) {
			if (other.registroCurso != null)
				return false;
		} else if (!registroCurso.equals(other.registroCurso))
			return false;
		return true;
	}


	
}
