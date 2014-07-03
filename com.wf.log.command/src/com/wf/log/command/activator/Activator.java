package com.wf.log.command.activator;

import org.eclipse.osgi.framework.console.CommandProvider;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.wf.log.command.UpdateConfigCommand;

public class Activator implements BundleActivator {

	private static BundleContext context;

	private ServiceRegistration<CommandProvider> updateConfigSR = null;
	
	public static BundleContext getContext() {
		return context;
	}
	
	
	@SuppressWarnings("unchecked")
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		updateConfigSR = (ServiceRegistration<CommandProvider>) context.registerService(CommandProvider.class.getName(), new UpdateConfigCommand(), null);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		if (updateConfigSR != null) {
			updateConfigSR.unregister();
			updateConfigSR = null;
		}
		
	}

}
