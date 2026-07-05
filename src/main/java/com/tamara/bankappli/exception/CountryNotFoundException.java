package com.tamara.bankappli.exception;

public class CountryNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//private String message;
	
	public CountryNotFoundException() {
		
	};
	
	public CountryNotFoundException(String message) {
		
		super(message);
	};
}
