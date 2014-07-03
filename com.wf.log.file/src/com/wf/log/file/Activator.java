package com.wf.log.file;

import org.osgi.framework.BundleContext;

import com.wf.log.external.AbstractLogBundleActivator;
import com.wf.log.file.internal.FileLogHandler;

public class Activator extends AbstractLogBundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	@Override
	public void start(BundleContext arg0) throws Exception {
		Activator.context = arg0;
		init(arg0, new FileLogHandler());
	}

	@Override
	public void stop(BundleContext arg0) throws Exception {
		Activator.context = null;
		destroy();
	}
	
	

}
