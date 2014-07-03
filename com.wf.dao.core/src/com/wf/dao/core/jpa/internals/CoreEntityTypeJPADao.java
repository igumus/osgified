package com.wf.dao.core.jpa.internals;

import java.util.List;

import com.wf.dao.base.AbstractJPADao;
import com.wf.dao.base.exceptions.SessionFactoryNotAvaliableException;
import com.wf.dao.core.ICoreEntityTypeDao;
import com.wf.dao.core.mapper.internals.CoreEntityTypeMapper;
import com.wf.model.CoreEntityType;

public class CoreEntityTypeJPADao extends AbstractJPADao<CoreEntityType> implements ICoreEntityTypeDao {

	public CoreEntityTypeJPADao() {
		super();
	}
	
	protected String prepareSql(String whereClause) {
		String sql = "SELECT "
						+ "ID, "
						+ "CLASS_NAME AS CLASSNAME, "
						+ "STATUS "
					+ "FROM "
						+ "CORE_ENTITY_TYPE "
					+ "WHERE "
						+ "1=1 "
						+ whereClause;	
		return sql;
	}
	
	@Override
	public CoreEntityType getById(Long id) {
		CoreEntityType type = new CoreEntityType();
		type.setId(id);
		return type;
	}

	@Override
	public void saveOrUpdate(CoreEntityType entity) throws SessionFactoryNotAvaliableException, Exception{
		save(entity);
	}

	@Override
	public List<CoreEntityType> findAll() throws SessionFactoryNotAvaliableException {
		List<CoreEntityType> list = query(prepareSql(""), new CoreEntityTypeMapper());
		return list;
	}

}
