package com.wf.log.command;

import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.eclipse.osgi.framework.console.CommandProvider;

import com.wf.dao.base.exceptions.SessionFactoryNotAvaliableException;
import com.wf.dao.core.ICoreKeyValueDao;
import com.wf.model.CoreKeyValue;

public class KeyValueCommands implements CommandProvider {

	private static final String KEYVALUE_PARSER = "=";
	private ICoreKeyValueDao coreKeyValueDao;

	public void setCoreKeyValueDao(ICoreKeyValueDao coreKeyValueDao) {
		this.coreKeyValueDao = coreKeyValueDao;
		System.out.println("coreKeyValue dao has just registered");
	}
	
	public ICoreKeyValueDao getCoreKeyValueDao() {
		return this.coreKeyValueDao;
	}
	
	public void _saveKeyValue(CommandInterpreter ci) {
		String argument = ci.nextArgument();
		if (argument != null && argument.contains(KEYVALUE_PARSER)) {
			String[] strings = argument.split(KEYVALUE_PARSER);
			
			String key=strings[0];
			String value = strings[1];
			if (this.coreKeyValueDao != null) {
				CoreKeyValue student = this.coreKeyValueDao.saveKeyValue(key, value);
				ci.println("Found : " + student.toString());
			} else {
				ci.println("CoreKeyValueJPA service not avaiable now");
			}
		} else {
			ci.println(saveKeyValueUsage());
		}
	}
	
	private String saveKeyValueUsage() {
		return "saveKeyValue key=value";
	}
	
	public void _getKeyValue(CommandInterpreter ci) {
		String argument = ci.nextArgument();
		if (argument != null) {
			Long keyValueId = Long.parseLong(argument);
			if (this.coreKeyValueDao != null) {
				CoreKeyValue student = this.coreKeyValueDao.getById(keyValueId);
				ci.println("Found : " + student.toString());
			} else {
				ci.println("CoreKeyValueJPA service not avaiable now");
			}
		} else {
			ci.println(saveKeyValueUsage());
		}
	}
	
	public void _updateKeyValue(CommandInterpreter ci) {
		String argument = ci.nextArgument();
		if (argument != null) {
			if (this.coreKeyValueDao != null) {
				try {
					this.coreKeyValueDao.saveOrUpdate(null);
					ci.println("Kaydedildi");
				} catch (SessionFactoryNotAvaliableException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				ci.println("CoreKeyValueJPA service not avaiable now");
			}
		} else {
			ci.println(saveKeyValueUsage());
		}
	}

	
	public String getHelp() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("---CoreKeyValue JPA commands---\n\t");
		buffer.append("saveKeyValue - Saves KeyValue with according id\n\t");
		buffer.append("getKeyValue - Gets KeyValue with given id\n\t");
		buffer.append("updateKeyValue - Updates KeyValue with given id\n");
		return buffer.toString();
	}
}
