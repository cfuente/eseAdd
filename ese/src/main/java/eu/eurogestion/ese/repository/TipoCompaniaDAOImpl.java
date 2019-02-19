package eu.eurogestion.ese.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eu.eurogestion.ese.domain.TipoCompania;

/**
 * @author Rmerino, alvaro
 *
 */

@Repository
@Transactional
public class TipoCompaniaDAOImpl extends GenericDAOImpl<TipoCompania, Integer> implements TipoCompaniaDAO {

}
