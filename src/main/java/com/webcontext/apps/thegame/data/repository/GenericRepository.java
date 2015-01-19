package com.webcontext.apps.thegame.data.repository;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * THis GenericRepository implements basic method for CRUD operation.
 * 
 * @author Frédéric Delorme<frederic.deelorme@web-context.com>
 *
 * @param <T>
 * @param <PK>
 */
public class GenericRepository<T, PK> implements IRepository<T, PK> {

	@Inject
	protected EntityManager em;

	/**
	 * This is the container for the Class of the <T> parameter.
	 */
	protected Class<T> inferedClass;

	@SuppressWarnings("unchecked")
	public Class<T> getGenericClass() throws ClassNotFoundException {
		if (inferedClass == null) {
			Type mySuperclass = getClass().getGenericSuperclass();
			Type tType = ((ParameterizedType) mySuperclass)
					.getActualTypeArguments()[0];
			String className = tType.toString().split(" ")[1];
			inferedClass = (Class<T>) Class.forName(className);
		}
		return inferedClass;
	}

	public GenericRepository() {
		super();
	}

	T entity;

	@Override
	public T retrieve(PK id) throws ClassNotFoundException {
		return em.find(getGenericClass(), id);
	}

	@Override
	public T create(T entity) throws Exception {
		em.persist(entity);
		em.flush();
		return entity;

	}

	@Override
	public T update(T entity) throws Exception {
		entity = em.merge(entity);
		em.flush();
		return entity;

	}

	@Override
	public void delete(T entity) throws Exception {
		em.remove(entity);
		em.flush();

	}

	@Override
	public List<T> findAll(int offset, int pageSize) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> criteria = cb.createQuery(inferedClass);
		Root<T> entity = criteria.from(inferedClass);
		criteria.select(entity).orderBy(cb.asc(entity.get("title")));
		return em.createQuery(criteria).getResultList();
	}

}