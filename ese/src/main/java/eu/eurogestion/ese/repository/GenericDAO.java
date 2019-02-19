package eu.eurogestion.ese.repository;

import java.io.Serializable;
import java.util.List;

/**
 * @author Rmerino, alvaro
 *
 */

public interface GenericDAO<T, ID extends Serializable> {

	/**
	 * Inserta (en caso de no existir) o modifica (si ya existe un registro con la misma ID) en la BBDD.
	 * @param entity Entidad a insertar/modificar.
	 */
	void saveOrUpdate(T entity) throws Exception;

	/**
	 * Busca un registro en la base de datos segun la ID introducida como parametro.
	 * @param id Clave primaria por la cual realizar la busqueda.
	 * @return Entidad correspondiente con la ID de entrada, NULL en caso de no encontrarse ningun registro.
	 */
	T get(ID id) throws Exception;

	/**
	 * Borra de forma fisica el registro correspondiente con la ID introducida como parametro.
	 * @param id Clave primaria por la cual realizar el borrado.
	 */
	void delete(ID id) throws Exception;

	/**
	 * Devuelve todos los regristro de la tabla desde la cual se realiza la llamada.
	 */
	List<T> findAll() throws Exception;
	
}