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
@Table(name = "tipo_compania", catalog = "eSe")
public class TipoCompania implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_tipo_compania", unique = true, nullable = false)
	private int idTipoCompania;
	
	@Column(name = "valor", length = 25)
	private String valor;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "compania")
	private List<Compania> listCompania;
}
