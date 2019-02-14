package eu.eurogestion.ese.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "compania", catalog = "eSe")
public class Compania implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_compania", unique = true, nullable = false)
	private int idCompania;
	
	@Column(name = "nombre", nullable = false, length = 200)
	private String nombre;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_compania")
	private int tipoCompania;
	
	@Column(name = "documento", nullable = false, length = 14)
	private String documento;
	
	@Column(name = "tipo_via", length = 10)
	private String tipoVia;
	
	@Column(name = "via", length = 30)
	private String via;
	
	@Column(name = "numero")
	private Integer numero;
	
	@Column(name = "planta")
	private Integer planta;
	
	@Column(name = "puerta", length = 10)
	private String puerta;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_baja", length = 10)
	private Date fechaBaja;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "compania")
	private List<Personal> listPersonal;

}
