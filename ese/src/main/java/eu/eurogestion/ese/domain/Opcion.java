package eu.eurogestion.ese.domain;
// Generated 11-feb-2019 14:05:28 by Hibernate Tools 5.2.11.Final

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Opcion generated by hbm2java
 */
@Entity
@Table(name = "opcion", catalog = "eSe")
public class Opcion implements java.io.Serializable {

	private int idOpcion;
	private String descripcion;
	private String nombre;
	private List<Perfil> perfiles;

	public Opcion() {
	}

	public Opcion(int idOpcion, String descripcion, String nombre, List<Perfil> perfiles) {
		this.idOpcion = idOpcion;
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.perfiles = perfiles;
	}

	@Id

	@Column(name = "id_opcion", unique = true, nullable = false)
	public int getIdOpcion() {
		return this.idOpcion;
	}

	public void setIdOpcion(int idOpcion) {
		this.idOpcion = idOpcion;
	}

	@Column(name = "descripcion", nullable = false, length = 50)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "nombre", nullable = false, length = 20)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "opcion")
	public List<Perfil> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(List<Perfil> perfiles) {
		this.perfiles = perfiles;
	}

}