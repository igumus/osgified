package com.wf.dao.core.jpa.internals;

import java.util.LinkedList;
import java.util.List;

import com.wf.dao.base.AbstractJPADao;
import com.wf.dao.base.exceptions.SessionFactoryNotAvaliableException;
import com.wf.dao.core.ICoreEntityDao;
import com.wf.model.CoreEntity;

public class CoreEntityJPADao extends AbstractJPADao<CoreEntity> implements ICoreEntityDao{

	@Override
	public CoreEntity getById(Long id) {
		CoreEntity entity = new CoreEntity();
		entity.setId(id);
		return entity;
	}

	@Override
	public void saveOrUpdate(CoreEntity entity) throws SessionFactoryNotAvaliableException, Exception{
		System.out.println(entity.getId() + " saveOrUpdated");
	}

	@Override
	public List<CoreEntity> findAll() {
		List<CoreEntity> list = new LinkedList<CoreEntity>();
		list.add(getById(1l));
		list.add(getById(2l));
		return list;
	}

}
