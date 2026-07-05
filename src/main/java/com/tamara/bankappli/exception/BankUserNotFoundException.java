package com.tamara.bankappli.exception;

public class BankUserNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//private String message;
	
	public BankUserNotFoundException() {
		
	};
	
	public BankUserNotFoundException(String message) {
		
		super(message);
	};
}
