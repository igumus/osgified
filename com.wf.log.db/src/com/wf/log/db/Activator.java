package com.wf.log.db;

import org.osgi.framework.BundleContext;

import com.wf.log.db.internal.DBLogHandler;
import com.wf.log.external.AbstractLogBundleActivator;

public class Activator extends AbstractLogBundleActivator{
	
	private static BundleContext context;


	static BundleContext getContext() {
		return context;
	}


	@Override
	public void start(BundleContext arg0) throws Exception {
		Activator.context = arg0;
		init(arg0, new DBLogHandler());
	}


	@Override
	public void stop(BundleContext arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
