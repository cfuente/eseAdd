package eu.eurogestion.ese.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "perfil", catalog = "eSe")
public class Perfil implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_perfil", unique = true, nullable = false)
	private Integer idPerfil;
	
	@Column(name = "nombre", nullable = false, length = 20)
	private String nombre;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_permiso", nullable = false)
	@ToString.Exclude
	private TipoPermiso permiso;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_opcion", nullable = false)
	@ToString.Exclude
	private Opcion opcion;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "perfil")
	@ToString.Exclude
	private List<Rol> listRol;
}
