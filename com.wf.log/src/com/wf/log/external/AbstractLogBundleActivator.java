package com.wf.log.external;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.log.LogListener;
import org.osgi.service.log.LogReaderService;

public abstract class AbstractLogBundleActivator implements BundleActivator {

	private LogReaderService logReaderService = null;
	private LogListener logListener = null;

	private void setLogReaderService(BundleContext context) {
		ServiceReference<?> serviceReference = context.getServiceReference(LogReaderService.class.getName());
		logReaderService = (LogReaderService) context.getService(serviceReference);
	}

	private void registerLogListener(AbstractLogHandler handler) {
		if (logReaderService != null) {
			if (logListener == null)
				logListener = handler;
			logReaderService.addLogListener(logListener);
		}
	}
	
	protected final void init(BundleContext context, AbstractLogHandler handler) {
		setLogReaderService(context);
		registerLogListener(handler);
	}
	
	protected final void destroy() {
		unregisterLogListener();
	}

	private void unregisterLogListener() {
		if (logReaderService != null) {
			logReaderService.removeLogListener(logListener);
		}
	}

	
}
