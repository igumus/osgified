package com.wf.dao.core.commands;

import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.eclipse.osgi.framework.console.CommandProvider;

import com.wf.dao.base.exceptions.SessionFactoryNotAvaliableException;
import com.wf.dao.core.ICoreEntityTypeDao;
import com.wf.model.CoreEntityType;

public class CoreEntityTypeCommands implements CommandProvider {

	private ICoreEntityTypeDao dao;

	public ICoreEntityTypeDao getDao() {
		return dao;
	}

	public void setDao(ICoreEntityTypeDao dao) {
		this.dao = dao;
		System.out.println(ICoreEntityTypeDao.class.getSimpleName() + " has just registered to " + this.getClass().getSimpleName());
	}

	@Override
	public String getHelp() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("--- DAO CoreEntityType Commands ---\n\t");
		buffer.append("getCoreEntityType    - Gets CoreEntityType object with given id\n\t");
		buffer.append("deleteCoreEntityType - Deletes CoreEntityType object with given id\n");
		return buffer.toString();
	}

	public void _deleteCoreEntityType(CommandInterpreter ci) throws SessionFactoryNotAvaliableException, Exception {
		if (this.dao != null) {
			String argument = ci.nextArgument();
			if (argument != null) {
				Long id = Long.parseLong(argument);
				if (id != null) {
					CoreEntityType entity = this.dao.getById(id);
					if (entity != null) {
						ci.println(entity.toString() + " is going to delete");
						entity.setStatus(Boolean.FALSE);
						this.dao.save(entity);
					} else
						ci.println("No CoreEntityType found for id :" + id);
				} else {
					ci.println("USAGE : " + usageDeleteCoreEntityType());
				}
			} else {
				ci.println("USAGE : " + usageDeleteCoreEntityType());
			}
		} else {
			ci.println(ICoreEntityTypeDao.class.getSimpleName() + " is not avaliable now");
		}
	}

	public String usageDeleteCoreEntityType() {
		return "deleteCoreEntityType <id (must be number)>";
	}

	public void _getCoreEntityType(CommandInterpreter ci) {
		if (this.dao != null) {
			String argument = ci.nextArgument();
			if (argument != null) {
				Long id = Long.parseLong(argument);
				if (id != null) {
					CoreEntityType entity = this.dao.getById(id);
					if (entity != null)
						ci.println(entity.toString());
					else
						ci.println("No CoreEntityType found for id :" + id);
				} else {
					ci.println("USAGE : " + usageGetCoreEntityType());
				}
			} else {
				ci.println("USAGE : " + usageGetCoreEntityType());
			}
		} else {
			ci.println(ICoreEntityTypeDao.class.getSimpleName() + " is not avaliable now");
		}
	}

	private String usageGetCoreEntityType() {
		return "getCoreEntityType <id (must be number)>";
	}

}
