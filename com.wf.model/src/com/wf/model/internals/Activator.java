package com.wf.model.internals;

import org.hibernate.SessionFactory;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.springframework.osgi.context.event.OsgiBundleApplicationContextListener;
import org.springframework.osgi.context.event.OsgiBundleContextRefreshedEvent;

public class Activator implements BundleActivator, OsgiBundleApplicationContextListener<OsgiBundleContextRefreshedEvent> {

	private static final String PLUGIN_ID = "com.wf.model";
	private static BundleContext context;
	private ServiceRegistration<SessionFactory> serviceRegistration = null;
	private ServiceRegistration<?> registerService = null;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		Activator.context = null;
		if (serviceRegistration != null) {
			serviceRegistration.unregister();
			serviceRegistration = null;
		}
		if (registerService != null) {
			registerService.unregister();
			registerService = null;
		}
	}

	@Override
	public void onOsgiApplicationEvent(OsgiBundleContextRefreshedEvent event) {
		System.out.println("refresh event'ini yakaladim.....");
		String symbolicName = event.getBundle().getSymbolicName();
		/*if (symbolicName.startsWith(PLUGIN_ID)) {
			SessionFactory sessionFactory = (SessionFactory) event.getApplicationContext().getBean("sessionFactory");
			serviceRegistration = (ServiceRegistration<SessionFactory>) Activator.context.registerService(SessionFactory.class.getName(), null, null);
		}*/
	}

}
