package com.teambingo.recruting_platform.database;

public class PersonAlreadyJoinException extends RuntimeException {

	private static final long serialVersionUID = -2587590249622016395L;

	public PersonAlreadyJoinException() {

	}
	
	public PersonAlreadyJoinException(String message) {
		super(message);

	}

	public PersonAlreadyJoinException(Throwable cause) {
		super(cause);
		
	}

	public PersonAlreadyJoinException(String message, Throwable cause) {
		super(message, cause);
		
	}

}
