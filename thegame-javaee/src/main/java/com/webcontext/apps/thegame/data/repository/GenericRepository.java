package com.webcontext.apps.thegame.data.repository;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.webcontext.apps.thegame.util.FileIO;

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
	 * Date formatter to be used to convert date in serialize/deserialize
	 * operations.
	 */
	protected Gson gson = new GsonBuilder()
			.setDateFormat("YYYY-mm-dd hh:MM:SS").create();

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
	public T retrieve(Long id) throws ClassNotFoundException {
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

	/**
	 * Count the number of entities <T> in database.
	 * 
	 * @return
	 */
	public long count() {
		CriteriaQuery<Long> cq = null;
		try {
			CriteriaBuilder qb = em.getCriteriaBuilder();
			cq = qb.createQuery(Long.class);
			cq.select(qb.count(cq.from(getGenericClass())));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return em.createQuery(cq).getSingleResult();
	}

	/**
	 * Read the T object list from a JSON file name <code>filePath</code>, and
	 * if <code>storeToDabase</code> is true, store loaded object to
	 * corresponding entity.
	 * 
	 * @param filePath
	 *            the JSON file to be read and parsed to produce a
	 *            <code>List<T></code> objects.
	 * @param storeToDatabase
	 *            a flag set to true if you need to store data from
	 *            <code>filePath</code> to database.
	 * @return return a list of T object as a <code>list<T></code>.
	 * @throws Exception
	 */
	public List<T> loadObjectFromJSONFile(String filePath,
			boolean storeToDatabase) throws Exception {
		URL path = Thread.currentThread().getContextClassLoader()
				.getResource("/");
		System.out.println("dataset path"+path.getPath());
		String json = FileIO.fastRead(filePath);
		/*
		 * TypeToken<List<T>> token = new TypeToken<List<T>>() { }; List<T> list
		 * = gson.fromJson(json, token.getType()); for (T entity : list) {
		 * this.create(entity); }
		 */
		ArrayList<T> list = gson.fromJson(json, new TypeToken<ArrayList<T>>() {
		}.getType());
		for (int i = 0, size = list.size(); i < size; i++) {
			T entity = gson.fromJson(gson.toJson(list.get(i)),
					getGenericClass());
			update(entity);
			list.set(i, entity);
		}

		return list;
	}

}