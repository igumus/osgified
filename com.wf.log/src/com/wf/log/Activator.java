package com.wf.log;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.cm.ManagedService;

import com.wf.log.core.DefaultLogHandler;
import com.wf.log.core.PrettyPrinterConfigurator;
import com.wf.log.external.AbstractLogBundleActivator;

public class Activator extends AbstractLogBundleActivator {

	private static final String CONFIG_PID = "PrettyPrinterConfigurator";
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	private ServiceRegistration<?> ppcService;

	@Override
	public void start(BundleContext theContext) throws Exception {
		Activator.context = theContext;
		init(theContext, new DefaultLogHandler());
		registerPrettyConfigurator();
	}
	
	private void registerPrettyConfigurator() {
		Dictionary<String, Object> props = new Hashtable<String, Object>();
		props.put(Constants.SERVICE_PID, CONFIG_PID);
	    ppcService = context.registerService(ManagedService.class.getName(),
	        new PrettyPrinterConfigurator(), props);
	    ppcService.setProperties(props);
	    System.out.println("PrettyPrinterConfigurator registration completed " + ConfigurationAdmin.SERVICE_BUNDLELOCATION);
	}

	@Override
	public void stop(BundleContext theContext) throws Exception {
		Activator.context = null;
		destroy();
		if (ppcService != null) {
			ppcService.unregister();
			ppcService = null;
		}
	}

	/*public static void addLogHandler(AbstractLogHandler logHandler) {

	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;

	}

	@SuppressWarnings("unused")
	private void addDefaultEventHandler() {
		String[] topics = new String[] { "com/acme/reportgenerator/*", "org/osgi/framework/BundleEvent/*" };

		Dictionary<String, Object> props = new Hashtable<String, Object>();
		props.put(EventConstants.EVENT_TOPIC, topics);
		context.registerService(EventHandler.class.getName(), new DefaultEventHandler(), props);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}*/

}
