package eu.eurogestion.ese.repository;

import java.util.List;

import eu.eurogestion.ese.domain.Personal;

public interface PersonalDAO extends GenericDAO<Personal, Integer> {

	public Personal getPersonalByNameUserPassword(String nameUser, String clave);
	
	public Personal getPersonalByNameUser(String nameUser);
	
	public List<Personal> getPersonalBajaByDni(String dni);

}
