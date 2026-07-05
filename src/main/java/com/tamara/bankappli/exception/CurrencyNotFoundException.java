package com.tamara.bankappli.exception;

public class CurrencyNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//private String message;
	
	public CurrencyNotFoundException() {
		
	};
	
	public CurrencyNotFoundException(String message) {
		
		super(message);
	};
}
