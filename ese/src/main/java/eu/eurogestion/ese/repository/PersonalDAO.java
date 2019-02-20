package eu.eurogestion.ese.repository;

import java.util.List;

import eu.eurogestion.ese.domain.Personal;

/**
 * @author Rmerino, alvaro
 *
 */

public interface PersonalDAO extends GenericDAO<Personal, Integer> {

	/**
	 * Obtiene un Personal a partir de nameUser y clave.
	 * 
	 * @param nameUser Usuario a buscar
	 * @param clave    Password del usuario a buscar
	 * @return Personal si lo encuentra, null en caso contrario
	 */
	public Personal getPersonalByNameUserPassword(String nameUser, String clave);

	/**
	 * Obtiene un Personal a partir de nameUser
	 * 
	 * @param nameUser Usuario a buscar
	 * @return Personal si lo encuentra, null en caso contrario
	 */
	public Personal getPersonalByNameUser(String nameUser);

	/**
	 * Obtiene una lista de Personales en estado de Baja a partir del dni
	 * 
	 * @param dni Dni del Personal a buscar
	 * @return Lista Personales (0-n).
	 */
	public List<Personal> getPersonalBajaByDni(String dni);

	public List<Personal> obtenerPersonal();

	public List<Personal> obtenerPersonalByFilters(String idCargo, String nombre);

}
