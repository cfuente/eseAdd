package eu.eurogestion.ese.repository;

import java.util.List;

import eu.eurogestion.ese.domain.Personal;

public interface PersonalDAO extends GenericDAO<Personal, Integer> {

	/**
	 * Obtiene un Personal a partir de nameUser y clave.
	 * @param nameUser
	 * @param clave
	 * @return Personal si lo encuentra, null en caso contrario
	 */
	public Personal getPersonalByNameUserPassword(String nameUser, String clave);
	
	/**
	 * Obtiene un Personal a partir de nameUser
	 * 
	 * @param nameUser
	 * @return Personal si lo encuentra, null en caso contrario
	 */
	public Personal getPersonalByNameUser(String nameUser);
	
	/**
	 * Obtiene una lista de Personales en estado de Baja a partir del dni
	 * 
	 * @param dni
	 * @return Lista Personales (0-n).
	 */
	public List<Personal> getPersonalBajaByDni(String dni);

}
