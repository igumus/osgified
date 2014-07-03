package com.wf.log.external;

import org.osgi.service.log.LogListener;

public abstract class AbstractLogHandler implements LogListener {
	
	protected String getLogHandlerName() {
		return this.getClass().getSimpleName();
	}

}
