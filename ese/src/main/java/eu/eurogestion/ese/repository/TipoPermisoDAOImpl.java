package eu.eurogestion.ese.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eu.eurogestion.ese.domain.TipoPermiso;

/**
 * @author Rmerino, alvaro
 *
 */

@Repository
@Transactional
public class TipoPermisoDAOImpl extends GenericDAOImpl<TipoPermiso, Integer> implements TipoPermisoDAO {

}