package eu.eurogestion.ese.repository;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eu.eurogestion.ese.domain.Personal;

@Repository
@Transactional
public class PersonalDAOImpl extends GenericDAOImpl<Personal, Integer> implements PersonalDAO {

	/**
	 * Metodo para comprobar si el usuario y la password introducida corresponden a
	 * un usuario
	 * 
	 * @param nombre
	 * @param clave
	 * @return
	 */
	public boolean login(String nombre, String clave) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Personal.class);
		criteria.add(Restrictions.eq("nombreUsuario", nombre)).add(Restrictions.eq("clave", clave));
		if (criteria.uniqueResult() != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo para obtener un personal dado su nombre de usuario
	 * 
	 * @param nombre
	 * @return
	 */
	public Personal getpersonalByNameUser(String nombre) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Personal.class);
		criteria.add(Restrictions.eq("nombreUsuario", nombre));
		return (Personal) criteria.uniqueResult();
	}
}