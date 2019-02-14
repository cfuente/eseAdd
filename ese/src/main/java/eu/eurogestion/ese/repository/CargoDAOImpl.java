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

import eu.eurogestion.ese.domain.Cargo;

@Repository
@Transactional
public class CargoDAOImpl extends GenericDAOImpl<Cargo, Integer> implements CargoDAO {
	
	public List<Cargo> findAllCargoAlta() {
		
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Cargo> cr = cb.createQuery(Cargo.class);
		Root<Cargo> root = cr.from(Cargo.class);

		List<Predicate> predicates = new ArrayList<>();
		predicates.add(cb.isNull(root.get("fechaBaja")));
		
		cr.select(root).where(predicates.toArray(new Predicate[]{}));
		 
		Query<Cargo> query = session.createQuery(cr);
		return query.getResultList();
	}

}