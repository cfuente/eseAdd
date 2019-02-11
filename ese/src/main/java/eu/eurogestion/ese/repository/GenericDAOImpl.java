package eu.eurogestion.ese.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public T create() throws Exception {
		try {
			return getEntityClass().newInstance();
		} catch (InstantiationException | IllegalAccessException ex) {
			throw new RuntimeException(ex);
		} catch (RuntimeException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

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
		if (entity == null) {
			throw new Exception("Los datos a borrar ya no existen");
		}
		sessionFactory.getCurrentSession().delete(entity);

	}

	@Override
	public List<T> findAll() throws Exception {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(getEntityClass());

		List<T> entities = criteria.list();

		return entities;

	}

	private Class<T> getEntityClass() {
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
}