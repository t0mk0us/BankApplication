package com.tamara.bankappli.exception;

public class PhoneNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//private String message;
	
	public PhoneNotFoundException() {
		
	};
	
	public PhoneNotFoundException(String message) {
		
		super(message);
	};
}
