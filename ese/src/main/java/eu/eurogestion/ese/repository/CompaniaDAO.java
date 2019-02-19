package eu.eurogestion.ese.repository;

import java.util.List;

import eu.eurogestion.ese.domain.Compania;


/**
 * @author Rmerino, alvaro
 *
 */

public interface CompaniaDAO extends GenericDAO<Compania, Integer> {

	/**
	 * Obtiene todas los Companias en activo.
	 * @return Lista de Companias (0-n).
	 */
	public List<Compania> findAllCompaniaAlta();
}
