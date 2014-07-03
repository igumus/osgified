package com.wf.dao.core.commands;

import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.eclipse.osgi.framework.console.CommandProvider;

import com.wf.dao.core.ICoreEntityDao;
import com.wf.model.CoreEntity;

public class CoreEntityCommands implements CommandProvider {

	private ICoreEntityDao dao = null;

	public CoreEntityCommands() {
		super();
	}

	public ICoreEntityDao getDao() {
		return dao;
	}

	public void setDao(ICoreEntityDao dao) {
		this.dao = dao;
		System.out.println(ICoreEntityDao.class.getSimpleName() + " has just registered to : " + this.getClass().getSimpleName());
	}

	@Override
	public String getHelp() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("--- DAO CoreEntity Commands ---\n\t");
		buffer.append("getCoreEntity - Gets CoreEntity object with given id\n");
		return buffer.toString();
	}
	
	private String usageGetCoreEntity() {
		return "getCoreEntity <id (must be number)>";
	}

	public void _getCoreEntity(CommandInterpreter ci) {
		if (this.dao != null) {
			String argument = ci.nextArgument();
			if (argument != null) {
				Long id = Long.parseLong(argument);
				if (id != null) {
					ci.println(id + " " + this.dao.getClass().getSimpleName() + ".getById ile cagirilacak");
					CoreEntity entity = this.dao.getById(id);
					if (entity != null)
						ci.println(entity.toString());
					else
						ci.println("No CoreEntity found for id :" + id);
				} else {
					ci.println("USAGE : " + usageGetCoreEntity());
				}
			} else {
				ci.println("USAGE : " + usageGetCoreEntity());
			}
		} else {
			ci.println(ICoreEntityDao.class.getSimpleName() + " is not avaliable now");
		}
	}

}
