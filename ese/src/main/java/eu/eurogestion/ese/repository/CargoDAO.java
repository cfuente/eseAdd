package eu.eurogestion.ese.repository;

import java.util.List;

import eu.eurogestion.ese.domain.Cargo;

/**
 * @author Rmerino, alvaro
 *
 */
public interface CargoDAO extends GenericDAO<Cargo, Integer> {

	/**
	 * Obtiene todos los Cargo en activo.
	 * @return Lista de Cargos (0-n).
	 */
	public List<Cargo> findAllCargoAlta();
	
}
