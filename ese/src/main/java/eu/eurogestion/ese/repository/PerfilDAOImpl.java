package eu.eurogestion.ese.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eu.eurogestion.ese.domain.Perfil;

@Repository
@Transactional
public class PerfilDAOImpl extends GenericDAOImpl<Perfil, Integer> implements PerfilDAO {

}