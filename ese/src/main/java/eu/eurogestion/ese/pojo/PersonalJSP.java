package eu.eurogestion.ese.pojo;

import java.util.List;

import eu.eurogestion.ese.domain.Personal;
import lombok.Data;

/**
 * @author Rmerino, alvaro
 *
 */
@Data
public class PersonalJSP {
	private String idCargo;
	private String nombre;
	private List<Integer> listIdPersonal;
}
