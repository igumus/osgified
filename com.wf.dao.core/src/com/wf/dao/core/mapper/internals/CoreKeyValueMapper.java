package com.wf.dao.core.mapper.internals;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wf.dao.base.Mapper;
import com.wf.model.CoreKeyValue;

public class CoreKeyValueMapper extends Mapper<CoreKeyValue> {

	public CoreKeyValueMapper() {
		super();
	}
	
	@Override
	public CoreKeyValue map(ResultSet resultSet) throws SQLException {
		CoreKeyValue coreKeyValue = new CoreKeyValue();
		
		return coreKeyValue;
	}

}
