package eu.eurogestion.ese.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eu.eurogestion.ese.domain.Cargo;

@Repository
@Transactional
public class CargoDAOImpl extends GenericDAOImpl<Cargo, Integer> implements CargoDAO {

}