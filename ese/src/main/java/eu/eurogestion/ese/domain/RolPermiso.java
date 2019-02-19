package eu.eurogestion.ese.domain;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

/**
 * @author Rmerino
 *
 */

@Data
@Entity
@Table(name = "rol_permiso", catalog = "eSe")
public class RolPermiso implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_rol_permiso", unique = true, nullable = false)
	private Integer idRolPermiso;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_rol", nullable = false)
	@ToString.Exclude
	private Rol rol;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_permiso", nullable = false)
	@ToString.Exclude
	private Permiso permiso;
}
