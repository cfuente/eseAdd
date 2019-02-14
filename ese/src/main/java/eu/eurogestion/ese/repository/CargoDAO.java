package eu.eurogestion.ese.repository;

import java.util.List;

import eu.eurogestion.ese.domain.Cargo;

public interface CargoDAO extends GenericDAO<Cargo, Integer> {

	public List<Cargo> findAllCargoAlta();
	
}
