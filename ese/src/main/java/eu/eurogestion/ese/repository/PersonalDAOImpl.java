package eu.eurogestion.ese.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eu.eurogestion.ese.domain.Personal;

@Repository
@Transactional
public class PersonalDAOImpl extends GenericDAOImpl<Personal, Integer> implements PersonalDAO {

	/**
	 * Obtiene un Personal con nameUser y clave.
	 * @param nameUser
	 * @param clave
	 * @return Personal si lo encuentra, null en caso contrario
	 */
	public Personal getPersonalByNameUserPassword(String nameUser, String clave) {
		
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Personal> cr = cb.createQuery(Personal.class);
		Root<Personal> root = cr.from(Personal.class);

		List<Predicate> predicates = new ArrayList<>();
		predicates.add(cb.equal(root.get("nombreUsuario"), nameUser));
		predicates.add(cb.equal(root.get("clave"), clave));
		predicates.add(cb.isNull(root.get("fechaBaja")));
		
		cr.select(root).where(predicates.toArray(new Predicate[]{}));
		 
		Query<Personal> query = session.createQuery(cr);
		List<Personal> listPersonal = query.getResultList();
		
		if(listPersonal.isEmpty()) {
			return null;
		}
		
		return listPersonal.get(0); 		
	}

	/**
	 * Obtiene un Personal a partir de nameUser
	 * 
	 * @param nameUser
	 * @return Personal si lo encuentra, null en caso contrario
	 */
	public Personal getPersonalByNameUser(String nameUser) {

		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Personal> cr = cb.createQuery(Personal.class);
		Root<Personal> root = cr.from(Personal.class);

		List<Predicate> predicates = new ArrayList<>();
		predicates.add(cb.equal(root.get("nombreUsuario"), nameUser));
		
		cr.select(root).where(predicates.toArray(new Predicate[]{}));
		 
		Query<Personal> query = session.createQuery(cr);
		List<Personal> listPersonal = query.getResultList();
		
		if(listPersonal.isEmpty()) {
			return null;
		}
		
		return listPersonal.get(0); 
	}
	
	/**
	 * Obtiene una list de Personales en estado Baja a partir del dni
	 * 
	 * @param dni
	 * @return Una lista con los Personales encontrados (0-n).
	 */
	public List<Personal> getPersonalBajaByDni(String dni) {

		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Personal> cr = cb.createQuery(Personal.class);
		Root<Personal> root = cr.from(Personal.class);

		List<Predicate> predicates = new ArrayList<>();
		predicates.add(cb.equal(root.get("documento"), dni));
		predicates.add(cb.isNotNull(root.get("fechaBaja")));
		
		cr.select(root).where(predicates.toArray(new Predicate[]{}));
		 
		Query<Personal> query = session.createQuery(cr);
		return query.getResultList();
	}
	
}