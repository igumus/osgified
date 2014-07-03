package com.wf.dao.base.exceptions;

import org.hibernate.SessionFactory;

public class SessionFactoryNotAvaliableException extends Exception {

	public SessionFactoryNotAvaliableException() {
		super(SessionFactory.class.getSimpleName() + " not avaliable");
	}
	
	public SessionFactoryNotAvaliableException(String message) {
		super(message);
	}
}
