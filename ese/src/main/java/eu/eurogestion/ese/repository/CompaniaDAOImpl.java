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

import eu.eurogestion.ese.domain.Compania;

/**
 * @author Rmerino, alvaro
 *
 */

@Repository
@Transactional
public class CompaniaDAOImpl extends GenericDAOImpl<Compania, Integer> implements CompaniaDAO {

	public List<Compania> findAllCompaniaAlta() {

		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Compania> cr = cb.createQuery(Compania.class);
		Root<Compania> root = cr.from(Compania.class);

		List<Predicate> predicates = new ArrayList<>();
		predicates.add(cb.isNull(root.get("fechaBaja")));
		
		cr.select(root).where(predicates.toArray(new Predicate[]{}));
		 
		Query<Compania> query = session.createQuery(cr);
		return query.getResultList();
	}
}