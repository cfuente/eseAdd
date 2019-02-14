package eu.eurogestion.ese.repository;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {

	void saveOrUpdate(T entity) throws Exception;

	T get(ID id) throws Exception;

	void delete(ID id) throws Exception;

	List<T> findAll() throws Exception;
}