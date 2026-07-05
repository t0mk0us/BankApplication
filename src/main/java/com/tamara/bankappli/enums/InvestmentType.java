package com.tamara.bankappli.enums;

public enum InvestmentType {
	
	BONDS(1L, "1"),
	MUTUAL_FUNDS(2L, "2"),
	EQUITY(3L, "3"),
	ETF(4L, "4"),
	STOCKS(5L, "5"),
	HEDGE_FUNDS(6L, "6"),
	INDEX_FUNDS(7L, "7"),
	OPTIONS(8L, "8"),
	FIXED_INCOME(9L, "9"),
	BOND_FUNDS(10L, "10"),
	CERTIFICATE_OF_DEPOSIT(11L, "11"),
	SWAP(12L, "12"),
	LONG_TERM_BONDS(13L, "13"),
	INCOME(14L, "14"), 
	GIC(15L, "15"), 
	CASH(16L, "16"),
	UNKNOWN(17L, "17");
	
	public final java.lang.String name;

    public final java.lang.Long id;

    InvestmentType(Long id, java.lang.String name) {
        this.name = name;
        this.id = id;
    }

    public java.lang.String getName() {
        return name;
    }

    public java.lang.Long getId() {
        return id;
    }
	
	public static InvestmentType getById(Long id) {
	    for(InvestmentType e : values()) {
	        if(e.id.equals(id)) return e;
	    }
	    return UNKNOWN;
	}
}
