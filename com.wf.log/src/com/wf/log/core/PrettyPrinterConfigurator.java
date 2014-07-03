package com.wf.log.core;

import java.util.Dictionary;

import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;

public class PrettyPrinterConfigurator implements ManagedService {

	@Override
	@SuppressWarnings("rawtypes")
	public void updated(Dictionary dictionary) throws ConfigurationException {
		if (dictionary == null) {
			System.out.println("ConfigurationAdmin uzerinden hic props gelmedi");
		} else {
			System.out.println("ConfigurationAdmin tarafindan " + dictionary.size());
		}
	}

}
