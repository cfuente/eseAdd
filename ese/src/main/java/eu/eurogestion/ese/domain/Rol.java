package eu.eurogestion.ese.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "rol", catalog = "eSe")
public class Rol implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_rol", unique = true, nullable = false)
	private Integer idRol;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_personal")
	private Personal personal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_perfil")
	private Perfil perfil;

}
