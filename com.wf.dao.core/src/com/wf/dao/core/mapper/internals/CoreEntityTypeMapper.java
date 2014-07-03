package com.wf.dao.core.mapper.internals;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wf.dao.base.Mapper;
import com.wf.model.CoreEntityType;

public class CoreEntityTypeMapper extends Mapper<CoreEntityType> {

	public CoreEntityTypeMapper() {
		super();
	}

	@Override
	public CoreEntityType map(ResultSet resultSet) throws SQLException {
		CoreEntityType coreEntityType = new CoreEntityType();
		
		coreEntityType.setId(resultSet.getLong("ID"));
		coreEntityType.setClassName(resultSet.getString("CLASSNAME"));
		coreEntityType.setStatus(resultSet.getBoolean("STATUS"));
		
		return coreEntityType;
	}

}
