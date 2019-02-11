package eu.eurogestion.ese.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eu.eurogestion.ese.domain.Compania;

@Repository
@Transactional
public class CompaniaDAOImpl extends GenericDAOImpl<Compania, Integer> implements CompaniaDAO {

}