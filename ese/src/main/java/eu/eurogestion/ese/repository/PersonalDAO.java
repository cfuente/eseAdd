package eu.eurogestion.ese.repository;

import eu.eurogestion.ese.domain.Personal;

public interface PersonalDAO extends GenericDAO<Personal, Integer> {

	/**
	 * Metodo para comprobar si el usuario y la password introducida corresponden a
	 * un usuario
	 * 
	 * @param nombre
	 * @param clave
	 * @return
	 */
	public boolean login(String nombre, String clave);
	
	/** Metodo para obtener un personal dado su nombre de usuario
	 * @param nombre
	 * @return
	 */
	public Personal getpersonalByNameUser(String nombre);

}
