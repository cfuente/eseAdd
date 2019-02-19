package eu.eurogestion.ese.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eu.eurogestion.ese.domain.RolPermiso;

@Repository
@Transactional
public class RolPermisoDAOImpl extends GenericDAOImpl<RolPermiso, Integer> implements RolPermisoDAO {

}
