package com.tamara.bankappli.exception;

public class AddressNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//private String message;
	
	public AddressNotFoundException() {
		
	};
	
	public AddressNotFoundException(String message) {
		
		super(message);
	};
}
