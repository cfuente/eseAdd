package eu.eurogestion.ese.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eu.eurogestion.ese.domain.Opcion;

/**
 * @author Rmerino, alvaro
 *
 */

@Repository
@Transactional
public class OpcionDAOImpl extends GenericDAOImpl<Opcion, Integer> implements OpcionDAO {

}