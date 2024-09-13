package com.tamara.bankappli.model;

import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.tamara.bankappli.enums.AccountStatus;
import com.tamara.bankappli.enums.AccountType;
import com.tamara.bankappli.enums.Currency;
import com.tamara.bankappli.model.Customer;

@Entity
@Table(name = "ACCOUNT")
public class Account {
		 
	@Id
	@Type(name = "org.hibernate.type.TextType", value = String.class)
	@GeneratedValue
	@Column(name = "id")
	private UUID ID;

	@OneToOne
    @JoinColumn(name = "owner")
	private Customer owner;
	
	@Column(name = "currency")
	private Currency currency;
	
	@Column(name = "balance")
	private Float balance;
	
	@Column(name = "account_type")
	private AccountType type;
	
	@Column(name = "status")
	private AccountStatus status;
	
	@Column(name = "debit_limit")
	private Float debitLimit;
	
	@Column(name = "monthly_payment")
	private Float monthly_payment;
	
	@Column(name = "missed_payments")
	private int missedPayments;
	
	@Column(name = "credit_interest")
	private Float credit_interest;
	
	@Column(name = "debit_interest")
	private Float debit_interest;
	
	public UUID getID() {
		
		return ID;
	}
	
	public void setID(UUID iD) {
		
		ID = iD;
	}

	public int getCurrencyId() {
	
		return this.currency.ordinal();
	}
		
	public int getAccountTypeId() {
	
		return this.type.ordinal();
	}
	
	public AccountType getType() {
		
		return type;
	}
	
	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	public void setType(AccountType type) {
	
		this.type = type;
	}

	public Float getDebitLimit() {
		return debitLimit;
	}

	public void setDebitLimit(Float debitLimit) {
		this.debitLimit = debitLimit;
	}

	public Float getMonthly_payment() {
		return monthly_payment;
	}

	public void setMonthly_payment(Float monthly_payment) {
		this.monthly_payment = monthly_payment;
	}

	public int getMissedPayments() {
		return missedPayments;
	}

	public void setMissedPayments(int missedPayments) {
		this.missedPayments = missedPayments;
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
	
	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	public Float getCredit_interest() {
		return credit_interest;
	}

	public void setCredit_interest(Float credit_interest) {
		this.credit_interest = credit_interest;
	}

	public Float getDebit_interest() {
		return debit_interest;
	}

	public void setDebit_interest(Float debit_interest) {
		this.debit_interest = debit_interest;
	}
	
	

	@Override
	public String toString() {
		return "Account [ID=" + ID + ", + type =" + type + ", currency="
				+ currency + "]";
		}

	@Override
	public int hashCode() {
		return Objects.hash(ID, currency, type);
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
				//&& Objects.equals(owner, other.owner)
				&& Objects.equals(type, other.type);
	}

}
