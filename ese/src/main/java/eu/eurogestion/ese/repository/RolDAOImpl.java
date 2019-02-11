package eu.eurogestion.ese.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eu.eurogestion.ese.domain.Rol;

@Repository
@Transactional
public class RolDAOImpl extends GenericDAOImpl<Rol, Integer> implements RolDAO {

}