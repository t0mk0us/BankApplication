package com.tamara.bankappli.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.tamara.bankappli.model.Customer;

@Entity
@Table(name = "ACCOUNT")
public class Account {
	
	enum AccountType {
		CHEQUING,
		SAVING,
		RRSP
	}
	  
	enum Currency {
		AMERICAN_DOLLAR,
		CANADIAN_DOLLAR,
		EURO,
		JAPANESE_YEN;
	}
		 
	@Id @GeneratedValue
	@Column(name = "id")  
	private long ID;

	@Column(name = "owner")
	private Customer owner;
	
	@Column(name = "currency")
	private Currency currency;
	
	@Column(name = "balance")
	private Float balance;
	
	@Column(name = "account_type")
	private AccountType type;
	
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public AccountType getType() {
		return type;
	}
	public void setType(AccountType type) {
		this.type = type;
	}
	public Customer getOwner() {
		return owner;
	}
	public void setOwner(Customer owner) {
		this.owner = owner;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	@Override
	public String toString() {
		return "Account [ID=" + ID + ", + =" + type + ", owner=" + owner + ", currency="
				+ currency + "]";
	}
	public Float getBalance() {
		return balance;
	}
	public void setBalance(Float balance) {
		this.balance = balance;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ID, currency, owner, type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(ID, other.ID) && Objects.equals(currency, other.currency)
				&& Objects.equals(owner, other.owner)
				&& Objects.equals(type, other.type);
	}

}
