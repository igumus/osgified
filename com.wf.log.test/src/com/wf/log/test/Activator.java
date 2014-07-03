package com.wf.log.test;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.osgi.service.log.LogService;

import com.wf.log.test.handler.DefaultEventHandler;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		log();
		addEventHandler();
		publishEvent();
	}

	private void addEventHandler() {
		String[] topics = new String[] { "com/acme/reportgenerator/*", "org/osgi/service/cm/ConfigurationEvent/*" };

		Dictionary<String, Object> props = new Hashtable<String, Object>();
		props.put(EventConstants.EVENT_TOPIC, topics);
		context.registerService(EventHandler.class.getName(), new DefaultEventHandler(), props);
	}

	@SuppressWarnings("unchecked")
	private void publishEvent() {
		ServiceReference<EventAdmin> ref = (ServiceReference<EventAdmin>) context.getServiceReference(EventAdmin.class.getName());
		if (ref != null) {
			EventAdmin eventAdmin = (EventAdmin) context.getService(ref);

			Dictionary<String, Object> properties = new Hashtable<String, Object>();
			properties.put("title", "title");
			properties.put("path", "path");
			properties.put("time", System.currentTimeMillis());

			Event reportGeneratedEvent = new Event("com/acme/reportgenerator/GENERATED", properties);

			eventAdmin.sendEvent(reportGeneratedEvent);
//			eventAdmin.postEvent(reportGeneratedEvent);
		} else {
			System.out.println("event admin yok");
		}
	}

	private void log() throws InvalidSyntaxException {
		ServiceReference<?>[] refs = context.getAllServiceReferences(LogService.class.getName(), null);
		if (refs != null) {
			ServiceReference<?> ref = refs[0];
			LogService log = (LogService) context.getService(ref);
			log.log(LogService.LOG_INFO, "message", new UnsupportedOperationException("UnsupportedOperationException message"));

		}
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
