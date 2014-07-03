package com.wf.dao.base;

import java.util.List;

import com.wf.dao.base.exceptions.SessionFactoryNotAvaliableException;
import com.wf.model.IEntity;

public interface IDao<T extends IEntity> {
	
	T getById(Long id);
	
	void save(T Entity) throws SessionFactoryNotAvaliableException, Exception ;
	
	void saveOrUpdate(T entity) throws SessionFactoryNotAvaliableException, Exception;
	
	List<T> query(String sql, Mapper<T> map) throws SessionFactoryNotAvaliableException;
	
	List<T> findAll() throws SessionFactoryNotAvaliableException;
	
}
