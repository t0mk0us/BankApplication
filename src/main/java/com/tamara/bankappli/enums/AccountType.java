package com.tamara.bankappli.enums;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

public enum AccountType {
	
	CHECKING {
		
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
	
	SAVING {
		
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
	
	RRSP {
		
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
	
	REEE {
		
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
	
	MORTGAGE {
		
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
	
	GARANTEED_LOC {
		
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
	
	//LOC = LINE OF CREDIT
	NON_GARANTEED_LOC {
		
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
	
	CREDIT_CARD {
		
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
	};

	public int getID() {
		// TODO Auto-generated method stub
		return 0;
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
