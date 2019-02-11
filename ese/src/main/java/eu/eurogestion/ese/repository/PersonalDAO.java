package eu.eurogestion.ese.repository;

import eu.eurogestion.ese.domain.Personal;

public interface PersonalDAO extends GenericDAO<Personal, Integer> {

	public boolean login(String nombre, String clave);

}
