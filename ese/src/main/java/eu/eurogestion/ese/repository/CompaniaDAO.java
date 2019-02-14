package eu.eurogestion.ese.repository;

import java.util.List;

import eu.eurogestion.ese.domain.Compania;

public interface CompaniaDAO extends GenericDAO<Compania, Integer> {

	public List<Compania> findAllCompaniaAlta();
}
