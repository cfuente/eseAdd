package eu.eurogestion.ese.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eu.eurogestion.ese.domain.Permiso;

/**
 * @author Rmerino, alvaro
 *
 */

@Repository
@Transactional
public class PerfilDAOImpl extends GenericDAOImpl<Permiso, Integer> implements PerfilDAO {

}