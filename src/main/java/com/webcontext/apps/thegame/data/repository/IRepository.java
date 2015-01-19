package com.webcontext.apps.thegame.data.repository;

import java.util.List;

public interface IRepository<T, PK> {

	public abstract T findById(PK id);

	public abstract List<T> findAll(PK id, int offset, int pageSize);

	public abstract void save(T entity) throws Exception;

	public abstract void delete(T entity) throws Exception;

}