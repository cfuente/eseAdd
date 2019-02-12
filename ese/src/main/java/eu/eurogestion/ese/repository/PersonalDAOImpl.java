package eu.eurogestion.ese.repository;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
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
				
		String cadena = "SELECT * FROM personal WHERE nombre_usuario = '" + nombre +"' AND clave = '" + clave + "';";
		
		@SuppressWarnings("unchecked")
		NativeQuery<Personal> query = sessionFactory.getCurrentSession().createSQLQuery(cadena);

		if (!query.getResultList().isEmpty()) {
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