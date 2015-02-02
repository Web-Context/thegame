package com.webcontext.apps.thegame.data.repository;

import java.util.List;

/**
 * INterface to describe basic needed operations to implements to provide some
 * CRUD operation.
 * <ul>
 * <li><strong>C</strong>reate : create a new entity in the persistence system,</li>
 * <li><strong>R</strong>etrieve operation can retrieve one or more entity,</li>
 * <li><strong>U</strong>pdate can update an existing entity,</li>
 * <li><strong>D</strong>elete an existing entity from the perisstence system.</li>
 * </ul>
 * 
 * @author Frédéric Delorme<frederic.delorme@web-context.com>
 *
 * @param <T>
 * @param <PK>
 */
public interface IRepository<T, PK> {

	/**
	 * Find an entity <T> on its primary key value <PK>
	 * 
	 * @param id
	 *            the unique identifier <PK> for the entity to be retrieved.
	 * @return return the corresponding entity <T> to the id key <PK> value.
	 */
	public abstract T retrieve(Long id) throws ClassNotFoundException;

	/**
	 * Retrieve all entities <T> from the persistence system.
	 * 
	 * @param id
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public abstract List<T> findAll(int offset, int pageSize);

	/**
	 * persist the entity <T> to the persistence system. an Id will be generated
	 * according to the id policy in the Entity id attribute .
	 * 
	 * @param entity
	 *            the entity <T> to persist.
	 * @return the entity <T> just created with its new id<PK>.
	 * @throws Exception
	 */
	public abstract T create(T entity) throws Exception;

	/**
	 * update an existing entity.
	 * 
	 * @param entity
	 *            the entity <T> to be updated.
	 * @return
	 * @throws Exception
	 */
	public abstract T update(T entity) throws Exception;

	/**
	 * Delete the entity from the persistence system.
	 * 
	 * @param entity
	 *            the entity <T> to be deleted.
	 * @throws Exception
	 */
	public abstract void delete(T entity) throws Exception;

}