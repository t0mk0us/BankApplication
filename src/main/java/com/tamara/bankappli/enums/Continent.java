package com.tamara.bankappli.enums;

public enum Continent {

	EUROPE(1L, "1"),
	ASIA(2L, "2"),
	NORTH_AMERICA(3L, "3"),
	SOUTH_AMERICA(4L, "4"),
	AUSTRALIA(5L, "5"), 
	UNKNOWN(6L, "6");
	
	public final java.lang.String name;

    public final java.lang.Long id;

    Continent(Long id, java.lang.String name) {
        this.name = name;
        this.id = id;
    }

    public java.lang.String getName() {
        return name;
    }

    public java.lang.Long getId() {
        return id;
    }
	
	public static Continent getById(Long id) {
	    for(Continent e : values()) {
	        if(e.id.equals(id)) return e;
	    }
	    return UNKNOWN;
	}
}
