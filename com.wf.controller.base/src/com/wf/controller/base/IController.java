package com.wf.controller.base;

import com.wf.controller.base.exceptions.DAONotAvaliableException;
import com.wf.dao.base.IDao;
import com.wf.model.IEntity;

public interface IController<D extends IDao<E>, E extends IEntity> {

	public E getEntity();
	
	public void setEntity(E anEntity);
	
	public D getDao();
	
	public void setDao(D aDao);
	
	public void unsetDao(D aDao);
	
	public E save() throws DAONotAvaliableException;
	
	public void preSave();
	
	public void afterSave();
	
	public void delete() throws DAONotAvaliableException;
	
	public void preDelete();
	
	public void afterDelete();
	
}
