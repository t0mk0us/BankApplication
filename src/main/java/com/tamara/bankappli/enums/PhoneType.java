package com.tamara.bankappli.enums;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

public enum PhoneType {

	 HOME_LANDLINE(1L, "1"),
	 WORK_LANDLINE(2L, "2"),
	 WORK_MOBILE(3L, "3"),
	 PERSONAL_MOBILE(4L, "4"),
	 UNKNOWN(5L, "5");
	
	public final java.lang.String name;

    public final java.lang.Long id;

    PhoneType(Long id, java.lang.String name) {
        this.name = name;
        this.id = id;
    }

    public java.lang.String getName() {
        return name;
    }

    public java.lang.Long getId() {
        return id;
    }
	
	public static PhoneType getById(Long id) {
	    for(PhoneType e : values()) {
	        if(e.id.equals(id)) return e;
	    }
	    return UNKNOWN;
	}
}
