package com.wf.log.console;

import org.osgi.framework.BundleContext;

import com.wf.log.console.internal.ConsoleLogHandler;
import com.wf.log.external.AbstractLogBundleActivator;

public class Activator extends AbstractLogBundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	@Override
	public void start(BundleContext theContext) throws Exception {
		Activator.context = theContext;
		init(theContext, new ConsoleLogHandler());
		
	}

	@Override
	public void stop(BundleContext arg0) throws Exception {
		Activator.context = null;
		destroy();		
	}



}
