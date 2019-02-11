package eu.eurogestion.ese.domain;
// Generated 11-feb-2019 14:05:28 by Hibernate Tools 5.2.11.Final

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TipoPermiso generated by hbm2java
 */
@Entity
@Table(name = "tipo_permiso", catalog = "eSe")
public class TipoPermiso implements java.io.Serializable {

	private int idPermiso;
	private String valor;
	private List<Perfil> perfiles;

	public TipoPermiso() {
	}

	public TipoPermiso(int idPermiso, String valor, List<Perfil> perfiles) {
		this.idPermiso = idPermiso;
		this.valor = valor;
		this.perfiles = perfiles;
	}

	@Id

	@Column(name = "id_permiso", unique = true, nullable = false)
	public int getPermiso() {
		return this.idPermiso;
	}

	public void setPermiso(int idPermiso) {
		this.idPermiso = idPermiso;
	}

	@Column(name = "valor", nullable = false, length = 0)
	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "permiso")
	public List<Perfil> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(List<Perfil> perfiles) {
		this.perfiles = perfiles;
	}

}
