package com.wf.controller.base;

import com.wf.controller.base.exceptions.DAONotAvaliableException;
import com.wf.dao.base.IDao;
import com.wf.model.IEntity;

public abstract class AbstractController<D extends IDao<E>, E extends IEntity> implements IController<D, E>{
	
	private D dao;
	private E entity;
	
	public AbstractController() {
		System.out.println(this.getClass().getSimpleName() + " initializing");
	}

	@Override
	public D getDao() {
		return this.dao;
	}
	
	@Override
	public void setDao(D aDao) {
		this.dao = aDao;
	}
	
	@Override
	public void unsetDao(D aDao) {
		this.dao = null;
	}
	
	@Override
	public E getEntity() {
		return this.entity;
	}
	
	@Override
	public void setEntity(E anEntity) {
		this.entity = anEntity;
	}
	
	@Override
	public E save() throws DAONotAvaliableException {
		if (this.dao != null) {
			preSave();
			System.out.println(getEntity().getClass().getSimpleName() + " with id : " + getEntity().getId() + " is saved");
			afterSave();
			return getEntity();
		} 
		
		throw new DAONotAvaliableException("dao");
	}
	
	@Override
	public void preSave() {
		getEntity().setStatus(Boolean.TRUE);
	}
	
	@Override
	public void afterSave() {
		
	}
	
	@Override
	public void delete() throws DAONotAvaliableException {
		if (this.dao != null) {
			preDelete();
			System.out.println(this.entity.getClass().getSimpleName() + " with id : " + this.entity.getId() + " is deleted");
			afterDelete();
		}
		
		throw new DAONotAvaliableException(this.getDao().getClass().getSimpleName());
	}
	
	@Override
	public void preDelete() {
		getEntity().setStatus(Boolean.FALSE);
	}
	
	@Override
	public void afterDelete() {
		
	}
	
}
