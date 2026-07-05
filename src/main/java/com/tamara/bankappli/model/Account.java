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

	//@Enumerated(EnumType.ORDINAL)
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "account_type")
	private AccountType accountType;
	
//    @ManyToOne
//    @JoinColumn(name = "account_type") // Name of your foreign key column in the database
//    private AccountType account_Type;
	
	@Column(name = "management_fee")
	private Float fees;
	
	/*
	 * @Column(name = "status") private AccountStatus status;
	 * 
	 * @Column(name = "debit_limit") private Float debitLimit;
	 * 
	 * @Column(name = "monthly_payment") private Float monthly_payment;
	 * 
	 * @Column(name = "missed_payments") private int missedPayments;
	 * 
	 * @Column(name = "credit_interest") private Float credit_interest;
	 * 
	 * @Column(name = "debit_interest") private Float debit_interest;
	 */
	
	public Account() {
		
	}
	
	public Account(Customer owner, Currency currency, Float balance, AccountType type, Float fees) {
		super();
		this.owner = owner;
		this.currency = currency;
		this.balance = balance;
		this.accountType = type;
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
	
	/*
	 * public AccountStatus getStatus() { return status; }
	 * 
	 * public void setStatus(AccountStatus status) { this.status = status; }
	 */

	/*
	 * public Float getDebitLimit() { return debitLimit; }
	 * 
	 * public void setDebitLimit(Float debitLimit) { this.debitLimit = debitLimit; }
	 * 
	 * public Float getMonthly_payment() { return monthly_payment; }
	 * 
	 * public void setMonthly_payment(Float monthly_payment) { this.monthly_payment
	 * = monthly_payment; }
	 * 
	 * public int getMissedPayments() { return missedPayments; }
	 * 
	 * public void setMissedPayments(int missedPayments) { this.missedPayments =
	 * missedPayments; }
	 */

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

	/*
	 * public Float getCredit_interest() { return credit_interest; }
	 * 
	 * public void setCredit_interest(Float credit_interest) { this.credit_interest
	 * = credit_interest; }
	 * 
	 * public Float getDebit_interest() { return debit_interest; }
	 * 
	 * public void setDebit_interest(Float debit_interest) { this.debit_interest =
	 * debit_interest; }
	 */

	public Float getFees() {
		return fees;
	}

	public void setFees(Float fees) {
		this.fees = fees;
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
