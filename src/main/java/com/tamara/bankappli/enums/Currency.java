package com.tamara.bankappli.enums;

public enum Currency {
	
	USD("United States Dollar", "$"),
	CAD("Canadian Dollar", "CA$"),
	EUR("Euro", "€"),
	CHF("Swiss Frank", "CHF"),
	CHE("WIR Euro", "CHE"),
	CHW("WIR Frank", "CHW"),
	GBP("Pound Sterling", "£"),
	ISK("Iceland Krona", ""),
	TRY("Turkish Lira", "₺"),
	ILS("New Israeli Sheqel", "₪"),
	HKD("Hong Kong Dollar", "HK$"),
	SGD("Singapore Dollar", "S$"),
	AUD("Australian Dollar", "AU$"),
	NZD("New Zealand Dollar", "NZ$"),
	JPY("Japanese Yen", "¥"),	
	DKK("Danish Krona", "kr"),
	SEK("Swedish Krona", "kr"),
	NOK("Norvegian Krone", "kr"),
	UAH("Ukrainian Hryvnia", "₴"),
	EMPTY("Empty Currency", "");
	
	public final String code;
	public final String symbol;
	
	private Currency(String c, String s) {
		
		this.code = c;   
		this.symbol = s; 
	}
	 
	public String getCode() {
		
		return this.code;
	
	}
	
	
	public String getSymbol() {
		
		return this.code;
	
	}
	
	public static Currency valueOfCodel(String code) {
	    for (Currency c : values()) 
	        if (c.code.equals(code)) {
	            return c;
	        }
	    return EMPTY;
	}
	    
	public static void printCode() {
	
	for (Currency c : Currency.values())
		System.out.println(c);
	}
}