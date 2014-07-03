package com.wf.model.commands;

import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.eclipse.osgi.framework.console.CommandProvider;

public class PrintModel implements CommandProvider{

	public void _print(CommandInterpreter ci) {
		ci.println("selam.");
	}
	
	@Override
	public String getHelp() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("---My Fragments commands---\n\t");
		buffer.append("print - prints message \n");
		return buffer.toString();
	}

}
