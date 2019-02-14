package eu.eurogestion.ese.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "tipo_permiso", catalog = "eSe")
public class TipoPermiso implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_permiso", unique = true, nullable = false)
	private int idPermiso;

	@Column(name = "valor", nullable = false, length = 0)
	private String valor;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "permiso")
	@ToString.Exclude
	private List<Perfil> listPerfil;
}
