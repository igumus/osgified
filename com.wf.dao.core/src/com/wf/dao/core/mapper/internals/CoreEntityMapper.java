package com.wf.dao.core.mapper.internals;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wf.dao.base.Mapper;
import com.wf.model.CoreEntity;

public class CoreEntityMapper extends Mapper<CoreEntity> {

	public CoreEntityMapper() {
		super();
	}	
	
	@Override
	public CoreEntity map(ResultSet resultSet) throws SQLException {
		CoreEntity coreEntity = new CoreEntity();
		
		return coreEntity;
	}

}
