package com.tamara.bankappli.model;

import java.util.Objects;
import java.util.UUID;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.tamara.bankappli.enums.AccountStatus;
import com.tamara.bankappli.enums.AccountType;
import com.tamara.bankappli.enums.InvestmentType;
import com.tamara.bankappli.model.Customer;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Component
@Table(name = "ACCOUNT")
public class Account {
		 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long ID;

	@JsonManagedReference
	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customer owner;

	@OneToOne // Removed @Enumerated
	@JoinColumn(name = "currency_id")
	private Currency currency;

	@Column(name = "balance")
	private Float balance;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "account_type")
	private AccountType accountType;
	
	@Column(name = "management_fee")
	private Float fees;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "account_status", columnDefinition = "tinyint")
	private AccountStatus accStatus;
	
	public Account() {
		
	}
	
	public Account(Customer owner, Currency currency, Float balance, AccountType type, Float fees) {
		super();
		this.owner = owner;
		this.currency = currency;
		this.balance = balance;
		this.accountType = type;
		this.accStatus = AccountStatus.OPEN;
		this.fees = fees;
	}
	
	public Long getID() {
		
		return ID;
	}

	public void setID(Long iD) {
		
		ID = iD;
	}

	public Long getCurrencyId() {
	
		return this.currency.getID();
	}
	
	public AccountType getType() {
		
		return accountType;
	}
	
	public void setType(AccountType type) {
		
		this.accountType = type;
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

	public Float getFees() {
		return fees;
	}

	public void setFees(Float fees) {
		this.fees = fees;
	}
	
	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public AccountStatus getStatus() {
		return accStatus;
	}

	public void setStatus(AccountStatus status) {
		this.accStatus = status;
	}

	@Override
	public int hashCode() {
		// Only use fields belonging directly to Account, or the owner object itself
		return Objects.hash(ID, currency, balance, accountType);
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
		return Objects.equals(ID, other.ID) 
				&& Objects.equals(currency, other.currency)
				&& Objects.equals(accountType, other.accountType)
				&& Objects.equals(owner, other.owner); // Safe null-checking handled by Objects.equals
	}
	
	@Override
	public String toString() {
		// Guard against a null owner to prevent crashes during logging
		String ownerName = (owner != null) ? (owner.getFirstName() + " " + owner.getLastName()) : "None";
		
		return "Account [ID=" + ID + ", Owner = " + ownerName + ", currency="
				+ (currency != null ? currency.toString() : "None") + ", Balance = " + balance + "]";
	}
}
