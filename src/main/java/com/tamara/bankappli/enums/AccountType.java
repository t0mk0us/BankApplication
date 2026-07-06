package com.tamara.bankappli.enums;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

public enum AccountType {
	
	CHECKING((short) 1, "Chequing") {
		
        @Override
        public boolean isChecking() {
            return true;
        }
        
    	public int getID() {
    		// TODO Auto-generated method stub
    		return this.ordinal();
    	}
    	
    	public String getType() {
    		// TODO Auto-generated method stub
    		return this.name();
    	}
	},
	SAVING((short) 2, "Saving") {
		
        @Override
        public boolean isSaving() {
            return true;
        }
        
    	public int getID() {
    		// TODO Auto-generated method stub
    		return this.ordinal();
    	}
    	
    	public String getType() {
    		// TODO Auto-generated method stub
    		return this.name();
    	}
	},
	RRSP((short) 3, "RRSP") {
		
        @Override
        public boolean isRRSP() {
            return true;
        }
        
    	public int getID() {
    		// TODO Auto-generated method stub
    		return this.ordinal();
    	}
    	
    	public String getType() {
    		// TODO Auto-generated method stub
    		return this.name();
    	}
	}, 
	REEE((short) 4, "REEE") {
		
        @Override
        public boolean isREEE() {
            return true;
        }
        
    	public int getID() {
    		// TODO Auto-generated method stub
    		return this.ordinal();
    	}
    	
    	public String getType() {
    		// TODO Auto-generated method stub
    		return this.name();
    	}
	}, 
	MORTGAGE((short) 5, "Mortgage") {
		
        @Override
        public boolean isMortgage() {
            return true;
        }
        
    	public int getID() {
    		// TODO Auto-generated method stub
    		return this.ordinal();
    	}
    	
    	public String getType() {
    		// TODO Auto-generated method stub
    		return this.name();
    	}
	}, 
	GARANTEED_LOC((short) 6, "Guaranteed Line of Credit") {
		
        @Override
        public boolean isGuaranteed_LOC() {
            return true;
        }
        
    	public int getID() {
    		// TODO Auto-generated method stub
    		return this.ordinal();
    	}
    	
    	public String getType() {
    		// TODO Auto-generated method stub
    		return this.name();
    	}
	}, 
	NOT_GARANTEED_LOC((short) 7, "Not Guaranteed Line of Credit") {
		
        @Override
        public boolean isNon_Guaranteed_LOC() {
            return true;
        }
        
    	public int getID() {
    		// TODO Auto-generated method stub
    		return this.ordinal();
    	}
    	
    	public String getType() {
    		// TODO Auto-generated method stub
    		return this.name();
    	}
	}, 
	CREDIT_CARD((short) 8, "Credit Card") {
		
        @Override
        public boolean isCredit_Card() {
            return true;
        }
        
    	public int getID() {
    		// TODO Auto-generated method stub
    		return this.ordinal();
    	}
    	
    	public String getType() {
    		// TODO Auto-generated method stub
    		return this.name();
    	}
	}, 
	UNKNOWN((short) 9, "Unknown status");
	
	public final java.lang.String name;

    public final Short id;

    AccountType(Short i, java.lang.String name) {
        this.name = name;
        this.id = i;
    }

	public boolean isCredit_Card() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isNon_Guaranteed_LOC() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isGuaranteed_LOC() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isMortgage() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isREEE() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isRRSP() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isSaving() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isChecking() {
		// TODO Auto-generated method stub
		return false;
	}	
}
