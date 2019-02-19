package eu.eurogestion.ese.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Rmerino, alvaro
 *
 */

@Transactional
public class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveOrUpdate(T entity) {

		sessionFactory.getCurrentSession().saveOrUpdate(entity);                                                                                       
	}

	@Override
	public T get(ID id) {

		return (T) sessionFactory.getCurrentSession().get(getEntityClass(), id);
	}

	@Override
	public void delete(ID id) throws Exception {

		T entity = (T) sessionFactory.getCurrentSession().get(getEntityClass(), id);
		if (entity != null) {
			sessionFactory.getCurrentSession().delete(entity);
		}
	}

	@Override
	public List<T> findAll() throws Exception {

		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<T> cr = cb.createQuery(getEntityClass());
		Root<T> root = cr.from(getEntityClass());
	
		cr.select(root);
		 
		Query<T> query = session.createQuery(cr);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	private Class<T> getEntityClass() {
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
}