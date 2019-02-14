package eu.eurogestion.ese.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "opcion", catalog = "eSe")
public class Opcion implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_opcion", unique = true, nullable = false)
	private int idOpcion;
	
	@Column(name = "descripcion", nullable = false, length = 50)
	private String descripcion;
	
	@Column(name = "nombre", nullable = false, length = 20)
	private String nombre;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "opcion")
	private List<Perfil> listPerfil;
}
