package eu.eurogestion.ese.repository;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eu.eurogestion.ese.domain.Personal;

@Repository
@Transactional
public class PersonalDAOImpl extends GenericDAOImpl<Personal, Integer> implements PersonalDAO {

	public boolean login(String nombre, String clave) {
		if (nombre == null || clave == null) {
			return false;
		}
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Personal.class);
		criteria.add(Restrictions.eq("nombreUsuario", nombre)).add(Restrictions.eq("clave", clave));
		if (criteria.uniqueResult() != null) {
			return true;
		} else {
			return false;
		}
	}
}