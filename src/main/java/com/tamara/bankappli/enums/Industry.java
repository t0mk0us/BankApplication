package com.tamara.bankappli.enums;

public enum Industry {

	GOVERNEMENT(1L, "1"),
	RETAIL(2L, "2"),
	CONSULTING(3L, "3"),
	TELECOM(4L, "4"),
	MEDIA(5L, "5"),
	SOFTWARE_DEVELOPMENT(6L, "6"),
	MEDICAL(7L, "7"),
	BUILDING(8L, "8"),
	BIOLOGY(9L, "9"),
	RESEARCH(10L, "10"),
	HEALTH(11L, "11"),
	LINGUISTICS(12L, "12"),
	COMMUNITY_HELP(13L, "13"),
	GROCERY(14L, "14"),
	FOOD(15L, "15"),
	PERSONAL_SERVICES(16L, "16"),
	MINING(17L, "17"),
	ACCOUNTING(18L, "18"),
	UNKNOWN(19L, "19");
	
	public final java.lang.String name;

    public final java.lang.Long id;

    Industry(Long id, java.lang.String name) {
        this.name = name;
        this.id = id;
    }

    public java.lang.String getName() {
        return name;
    }

    public java.lang.Long getId() {
        return id;
    }
	
	public static Industry getById(Long id) {
	    for(Industry e : values()) {
	        if(e.id.equals(id)) return e;
	    }
	    return UNKNOWN;
	}
}
