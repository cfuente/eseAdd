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
@Table(name = "cargo", catalog = "eSe")
public class Cargo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_cargo", unique = true, nullable = false)
	private int idCargo;
	
	@Column(name = "nombre", length = 200)
	private String nombre;
	
	@Column(name = "descripcion", length = 500)
	private String descripcion;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cargo")
	private List<Personal> personales;

}
