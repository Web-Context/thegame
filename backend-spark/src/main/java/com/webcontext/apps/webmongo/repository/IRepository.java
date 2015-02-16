/**
 * 
 */
package com.webcontext.apps.webmongo.repository;

import java.util.List;


/**
 * Standard Respository interface for Data access.
 * 
 * @author Frederic Delorme<frederic.delorme@web-context.com>
 *
 */
public interface IRepository<T> {
	
	/**
	 * retrieve a T entity byits id.
	 * @param id Unique identifier for the T entity. 
	 * @return T entity corresponding to the id.
	 */
	public T findById(String id);

	/**
	 * retrieve all T entities.
	 * @param offset start entity offset in the database.
	 * @param pageSize number of entity to be retrieved.
	 * @return List<T> list of entities retrieve from database.
	 */
	public List<T> findAll(long offset, long pageSize);

	public T update(String Id, T entity);

	public T save(T entity);

	public void delete(T entity);
}
