package com.tamara.bankappli.enums;

public enum CompanyType {
	
	PUBLIC(1L, "1"),
    PRIVATE(2L, "2"),
	COMMUNITY(3L, "3"),
	NON_PROFIT(4L, "4"),
	FREELANCE(5L, "5"), 
	UNKNOWN(6L, "6");
	
	public final java.lang.String name;

    public final java.lang.Long id;

    CompanyType(Long id, java.lang.String name) {
        this.name = name;
        this.id = id;
    }

    public java.lang.String getName() {
        return name;
    }

    public java.lang.Long getId() {
        return id;
    }
	
	public static CompanyType getById(Long id) {
	    for(CompanyType e : values()) {
	        if(e.id.equals(id)) return e;
	    }
	    return UNKNOWN;
	}
}
