package com.tamara.bankappli.exception;

public class AccountNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//private String message;
	
	public AccountNotFoundException() {
		
	};
	
	public AccountNotFoundException(String message) {
		
		super(message);
	};
}
