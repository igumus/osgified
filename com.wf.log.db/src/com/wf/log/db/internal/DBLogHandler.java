package com.wf.log.db.internal;

import org.osgi.service.log.LogEntry;

import com.wf.log.external.AbstractLogHandler;

public class DBLogHandler extends AbstractLogHandler {

	@Override
	public void logged(LogEntry entry) {
		System.out.println("{" + getLogHandlerName() + "} [" + entry.getBundle().getBundleId() + ":" + entry.getBundle().getSymbolicName() + "]: " + entry.getMessage());
	}

}
