package com.wf.log.command;

import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.eclipse.osgi.framework.console.CommandProvider;

import com.wf.dao.base.exceptions.SessionFactoryNotAvaliableException;
import com.wf.dao.core.ICoreEntityTypeDao;
import com.wf.model.CoreEntityType;

public class EntityTypeCommands implements CommandProvider {

	private ICoreEntityTypeDao coreEntityTypeDao;
	
	@Override
	public String getHelp() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("---CoreEntityType DAO commands---\n\t");
		buffer.append("saveEntityType - Saves EntityType with classname\n\t");
		buffer.append("findEntityType - Gets EntityType with given id\n\t");
		buffer.append("findAllEntityType - Updates KeyValue with given id\n");
		return buffer.toString();
	}
	
	public void setDao(ICoreEntityTypeDao aDao) {
		this.coreEntityTypeDao = aDao;
	}
	
	public void unsetDao(ICoreEntityTypeDao aDao) {
		this.coreEntityTypeDao = null;
	}
	
	private String getSaveEntityTypeUsage() {
		return "saveEntityType <classname>";
	}
	
	public void _saveEntityType(CommandInterpreter ci) {
		if (this.coreEntityTypeDao != null) {
			String argument = ci.nextArgument();
			if (argument != null) {
				CoreEntityType type = new CoreEntityType();
				type.setClassName(argument);
				try {
					this.coreEntityTypeDao.saveOrUpdate(type);
				} catch (SessionFactoryNotAvaliableException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				ci.println(getSaveEntityTypeUsage());
			}
		} else {
			ci.println(ICoreEntityTypeDao.class.getSimpleName() + " is not avaliable now");
		}
	}
	
	
	

}
