package com.wf.log.command;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.eclipse.osgi.framework.console.CommandProvider;
import org.osgi.framework.ServiceReference;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;

import com.wf.log.command.activator.Activator;

public class UpdateConfigCommand implements CommandProvider {

	private static final String KEYVALUE_PARSER = "=";

	public void _updateConfig(CommandInterpreter ci) {
		String argument = ci.nextArgument();
		if (argument != null && argument.contains(KEYVALUE_PARSER)) {
			String[] keyValues = argument.split(KEYVALUE_PARSER);
			String key = keyValues[0];
			String value = keyValues[1];
			ci.println("Passed key=" + key + ", value=" + value);
			pushKeyValue(key, value);
		} else {
			ci.println(getUsage());
		}
	}

	private void pushKeyValue(String key, String value) {
		ServiceReference<?> reference = Activator.getContext().getServiceReference(ConfigurationAdmin.class.getName());
		if (reference != null) {
			ConfigurationAdmin service = (ConfigurationAdmin) Activator.getContext().getService(reference);
			if (service != null) {
				try {
					Configuration configuration = service.getConfiguration("PrettyPrinterConfigurator");
					if (configuration != null) {
						Dictionary<String, Object> properties = configuration.getProperties();
						if (properties == null)
							properties = new Hashtable<String, Object>();
						properties.put(key, value);
						configuration.update(properties);
						configuration.update();
					} else {
						System.out.println("configuration (PrettyPrinterConfigurator) bulunamadi");
					}
				} catch (IOException e) {
					System.out.println("hata olustu: ");
					e.printStackTrace(System.out);
				}
			} else {
				System.out.println("ConfigurationAdmin servisini bulamadim.");
			}
		} else {
			System.out.println("ConfigurationAdmin servisine ait bir referans bulamadim.");
		}
	}

	public String getHelp() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("---My commands---\n\t");
		buffer.append("updateConfig - Updates configuration over ConfigurationAdmin service\n");
		return buffer.toString();
	}

	private String getUsage() {
		return "updateConfig key=value";
	}

}
