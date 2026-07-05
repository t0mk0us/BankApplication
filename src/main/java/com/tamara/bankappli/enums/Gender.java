package com.tamara.bankappli.enums;

public enum Gender {

	MALE(1L, "1"),
    FEMALE(2L, "2"),
    NON_BINARY(3L, "3"), 
    UNKNOWN(4L, "4");
	
	public final java.lang.String name;

    public final java.lang.Long id;

    Gender(Long id, java.lang.String name) {
        this.name = name;
        this.id = id;
    }

    public java.lang.String getName() {
        return name;
    }

    public java.lang.Long getId() {
        return id;
    }
	
	public static Gender getById(Long id) {
	    for(Gender e : values()) {
	        if(e.id.equals(id)) return e;
	    }
	    return UNKNOWN;
	}
}
