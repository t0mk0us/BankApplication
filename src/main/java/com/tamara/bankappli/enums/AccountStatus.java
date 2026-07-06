package com.tamara.bankappli.enums;

public enum AccountStatus {

	OPEN((short) 1, "Open"),
	CLOSED((short) 2, "Closed"),
	DEBT_RECOVERY((short) 3, "In debt recovery"), 
	UNKNOWN((short) 4, "Unknown status");
	
	public final java.lang.String name;

    public final Short id;

    AccountStatus(Short i, java.lang.String name) {
        this.name = name;
        this.id = i;
    }

    public java.lang.String getName() {
        return name;
    }

    public Short getId() {
        return id;
    }
	
	public static AccountStatus getById(Long id) {
	    for(AccountStatus e : values()) {
	        if(e.id.equals(id)) return e;
	    }
	    return UNKNOWN;
	}
}
