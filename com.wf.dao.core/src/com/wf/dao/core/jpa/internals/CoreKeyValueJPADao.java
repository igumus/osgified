package com.wf.dao.core.jpa.internals;

import java.util.LinkedList;
import java.util.List;

import com.wf.dao.base.AbstractJPADao;
import com.wf.dao.base.exceptions.SessionFactoryNotAvaliableException;
import com.wf.dao.core.ICoreKeyValueDao;
import com.wf.model.CoreKeyValue;

public class CoreKeyValueJPADao extends AbstractJPADao<CoreKeyValue> implements ICoreKeyValueDao{

	public CoreKeyValueJPADao() {
		super();
	}
	
	
	
	@Override
	public CoreKeyValue getById(Long id) {
		CoreKeyValue keyValue = new CoreKeyValue();
		keyValue.setId(id);
		keyValue.setKey("defaultKey");
		keyValue.setValue("defaultValue");
		keyValue.setStatus(Boolean.TRUE);
		return keyValue;
	}

	@Override
	public void saveOrUpdate(CoreKeyValue entity) throws SessionFactoryNotAvaliableException, Exception {
		save(entity);
	}

	@Override
	public List<CoreKeyValue> findAll() {
		List<CoreKeyValue> list = new LinkedList<CoreKeyValue>();
		list.add(getById(1l));
		list.add(getById(2l));
		return list;
	}

	@Override
	public CoreKeyValue saveKeyValue(String key, String value) {
		CoreKeyValue result = new CoreKeyValue();
		result.setKey(key);
		result.setValue(value);
		result.setStatus(true);
		
		
		
		return result;
	}

}
