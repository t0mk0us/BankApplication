package com.tamara.bankappli.exception;

public class CompanyNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//private String message;
	
	public CompanyNotFoundException() {
		
	};
	
	public CompanyNotFoundException(String message) {
		
		super(message);
	};
}
