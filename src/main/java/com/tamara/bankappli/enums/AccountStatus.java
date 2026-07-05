package com.tamara.bankappli.enums;

public enum AccountStatus {

	OPEN(1L, "1"),
	CLOSED(2L, "2"),
	DEBT_RECOVERY(3L, "3"), 
	UNKNOWN(4L, "4");
	
	public final java.lang.String name;

    public final java.lang.Long id;

    AccountStatus(Long id, java.lang.String name) {
        this.name = name;
        this.id = id;
    }

    public java.lang.String getName() {
        return name;
    }

    public java.lang.Long getId() {
        return id;
    }
	
	public static AccountStatus getById(Long id) {
	    for(AccountStatus e : values()) {
	        if(e.id.equals(id)) return e;
	    }
	    return UNKNOWN;
	}
}
