package com.wf.controller.base.exceptions;

public class DAONotAvaliableException extends Exception {
	
	public DAONotAvaliableException() {
		this("DAO is not avaliable for now");
	}
	
	public DAONotAvaliableException(String message) {
		super(message);
	}

}
