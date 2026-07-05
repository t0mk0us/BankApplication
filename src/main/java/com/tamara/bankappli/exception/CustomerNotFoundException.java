package com.tamara.bankappli.exception;

public class CustomerNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//private String message;
	
	public CustomerNotFoundException() {
		
	};
	
	public CustomerNotFoundException(String message) {
		
		super(message);
	};
}
