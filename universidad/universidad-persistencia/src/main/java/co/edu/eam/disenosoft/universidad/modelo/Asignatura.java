package co.edu.eam.disenosoft.universidad.modelo;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import co.edu.eam.disenosoft.universidad.modelo.enumeraciones.TipoAsignaturaEnum;


@Entity
@Table(name="tb_asignatura")
public class Asignatura implements Serializable{

	@Id
	@Column(name="codigo_asig", length=50)
	private String codigo;
	

	@Column(name="nombre_asig", nullable=false, length=50)
	private String nombre;
	

	@Column(name="numerocreditos_asig", nullable=false)
	private int numeroCreditos;
	

	@Column(name="semestre_asig", nullable=false)
	private int semestre;
	

	@Enumerated(EnumType.STRING)
	@Column(name="tipo_asig", length=50, nullable=false)
	private TipoAsignaturaEnum tipo;

	public Asignatura() {
	
	}
	/**
	 * @param nombre
	 * @param codigo
	 * @param tipo
	 * @param numeroCreditos
	 */
        public Asignatura(String nombre, String codigo, TipoAsignaturaEnum tipo, int numeroCreditos, int semestre) {
            this.nombre = nombre;
            this.codigo = codigo;
            this.tipo = tipo;
            this.numeroCreditos = numeroCreditos;
            this.semestre = semestre;
        }
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the tipo
	 */
	public TipoAsignaturaEnum getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(TipoAsignaturaEnum tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return the numeroCreditos
	 */
	public int getNumeroCreditos() {
		return numeroCreditos;
	}
	/**
	 * @param numeroCreditos the numeroCreditos to set
	 */
	public void setNumeroCreditos(int numeroCreditos) {
		this.numeroCreditos = numeroCreditos;
	}
        public int getSemestre() {
            return semestre;
        }

        public void setSemestre(int semestre) {
            this.semestre = semestre;
        }
	
	

}
