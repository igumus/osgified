package com.wf.log.test.handler;

import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

public class DefaultEventHandler implements EventHandler {

	@Override
	public void handleEvent(Event event) {
		System.out.println("CONSOLE : " + getEventAsString(event));
	}

	private String getEventAsString(Event event) {
		StringBuffer buffer = new StringBuffer();

		buffer.append("{TOPIC:" + event.getTopic() + " ");
		buffer.append("PROPERTIES: {");
		for (String propertyName : event.getPropertyNames()) {
			buffer.append("[" + propertyName + ":" + event.getProperty(propertyName).toString() + "] ");
		}
		buffer.append("}");
		return buffer.toString();
	}

}
