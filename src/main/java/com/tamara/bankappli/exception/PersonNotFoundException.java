package com.tamara.bankappli.exception;

public class PersonNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//private String message;
	
	public PersonNotFoundException() {
		
	};
	
	public PersonNotFoundException(String message) {
		
		super(message);
	};
}
