package eu.eurogestion.ese.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.Data;
import lombok.ToString;

/**
 * @author Rmerino, alvaro
 *
 */

@Data
@Entity
@Table(name = "personal", catalog = "eSe")
public class Personal implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_personal", unique = true, nullable = false)
	private Integer idPersonal;

	@Column(name = "documento", nullable = false, length = 14)
	private String documento;

	@Column(name = "nombre", length = 30)
	private String nombre;

	@Column(name = "apellido1", length = 30)
	private String apellido1;

	@Column(name = "apellido2", length = 30)
	private String apellido2;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_nac", length = 10)
	private Date fechaNac;

	@Column(name = "tipo_via", length = 10)
	private String tipoVia;

	@Column(name = "via", length = 30)
	private String via;

	@Column(name = "numero")
	private Integer numero;

	@Column(name = "planta")
	private Integer planta;

	@Column(name = "puerta", length = 2)
	private String puerta;

	@Column(name = "nombre_usuario", length = 20)
	private String nombreUsuario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_compania")
	@ToString.Exclude
	private Compania compania;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cargo")
	@ToString.Exclude
	private Cargo cargo;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_baja", length = 10)
	private Date fechaBaja;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_rol")
	@ToString.Exclude
	private Rol rol;

	@Column(name = "clave")
	private String clave;

	@Column(name = "licencia")
	private String licencia;

	@Column(name = "doc_empresa")
	private String docEmpresa;

	@Column(name = "email", length = 50)
	private String email;

	@Transient
	private String nombrePersonal;

	@Transient
	public String getNombrePersonal() {
		String nombreString = nombre + " " + apellido1;

		if (cargo != null) {
			nombreString += " " + cargo.getNombre();
		}
		return nombreString;
	}
}
