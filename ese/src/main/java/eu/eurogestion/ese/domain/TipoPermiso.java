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

/**
 * @author Rmerino, alvaro
 *
 */

@Data
@Entity
@Table(name = "tipo_permiso", catalog = "eSe")
public class TipoPermiso implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_tipo_permiso", unique = true, nullable = false)
	private int idTipoPermiso;

	@Column(name = "valor", nullable = false, length = 20)
	private String valor;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoPermiso")
	@ToString.Exclude
	private List<Permiso> listPermiso;
}
