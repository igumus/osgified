package com.wf.dao.core.commands;

import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.eclipse.osgi.framework.console.CommandProvider;

import com.wf.dao.core.ICoreKeyValueDao;
import com.wf.model.CoreKeyValue;

public class CoreKeyValueCommands implements CommandProvider {
	private static final String KEYVALUE_PARSER = "=";
	private ICoreKeyValueDao dao = null;

	public ICoreKeyValueDao getDao() {
		return dao;
	}

	public void setDao(ICoreKeyValueDao dao) {
		this.dao = dao;
		System.out.println(ICoreKeyValueDao.class.getSimpleName() + " has just registered to " + this.getClass().getSimpleName());
	}

	@Override
	public String getHelp() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("--- DAO CoreKeyValue Commands---\n\t");
		buffer.append("saveKeyValue - Saves KeyValue with according id\n\t");
		buffer.append("getKeyValue - Gets KeyValue with given id\n");
		return buffer.toString();
	}

	private void printServiceError(CommandInterpreter ci) {
		ci.println(ICoreKeyValueDao.class.getSimpleName() + " is not avaiable now");
	}

	public void _saveKeyValue(CommandInterpreter ci) {
		String argument = ci.nextArgument();
		if (argument != null && argument.contains(KEYVALUE_PARSER)) {
			String[] strings = argument.split(KEYVALUE_PARSER);

			String key = strings[0];
			String value = strings[1];
			if (this.dao != null) {
				CoreKeyValue student = this.dao.saveKeyValue(key, value);
				ci.println("Found : " + student.toString());
			} else {
				printServiceError(ci);
			}
		} else {
			ci.println(usageSaveKeyValue());
		}
	}

	private String usageSaveKeyValue() {
		return "saveKeyValue <key>=<value>";
	}

	public void _getKeyValue(CommandInterpreter ci) {
		String argument = ci.nextArgument();
		if (argument != null) {
			Long keyValueId = Long.parseLong(argument);
			if (this.dao != null) {
				CoreKeyValue entity = this.dao.getById(keyValueId);
				ci.println("Found : " + entity.toString());
			} else {
				printServiceError(ci);
			}
		} else {
			ci.println(usageGetKeyValue());
		}
	}

	private String usageGetKeyValue() {
		return "getKeyValue <id (must be number)>";
	}

}
