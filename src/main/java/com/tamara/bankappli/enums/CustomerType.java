package com.tamara.bankappli.enums;

public enum CustomerType {
	
	PERSON(1L, "1"), 
	ENTERPRISE(2L, "2"),
	UNKNOWN(3L, "3");
	
	public final java.lang.String name;

    public final java.lang.Long id;

    CustomerType(Long id, java.lang.String name) {
        this.name = name;
        this.id = id;
    }

    public java.lang.String getName() {
        return name;
    }

    public java.lang.Long getId() {
        return id;
    }
	
	public static CustomerType getById(Long id) {
	    for(CustomerType e : values()) {
	        if(e.id.equals(id)) return e;
	    }
	    return UNKNOWN;
	}

}
