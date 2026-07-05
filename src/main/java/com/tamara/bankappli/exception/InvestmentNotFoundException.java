package com.tamara.bankappli.exception;

public class InvestmentNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//private String message;
	
	public InvestmentNotFoundException() {
		
	};
	
	public InvestmentNotFoundException(String message) {
		
		super(message);
	};
}
