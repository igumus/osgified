package com.wf.dao.core;

import com.wf.dao.base.IDao;
import com.wf.model.CoreKeyValue;

public interface ICoreKeyValueDao extends IDao<CoreKeyValue> {
	
	public CoreKeyValue saveKeyValue(String key, String value);

}
