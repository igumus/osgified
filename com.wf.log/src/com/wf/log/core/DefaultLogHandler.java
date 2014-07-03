package com.wf.log.core;

import org.osgi.service.log.LogEntry;

import com.wf.log.external.AbstractLogHandler;

public class DefaultLogHandler extends AbstractLogHandler {

	@Override
	public void logged(LogEntry entry) {
		System.out.println("{" + getLogHandlerName() + "} [" + entry.getBundle().getBundleId() + ":" + entry.getBundle().getSymbolicName() + "]: " + entry.getMessage());
	}

}
