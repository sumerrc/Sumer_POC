package com.xoriant.bank.poc.entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accountId;
	private int accountNumber;
	private String accountHolderName;
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	private LocalDate openDate;
	@Column(columnDefinition = "TINYINT(1)")
	private boolean accountStatus;
	private double balance;

	@OneToMany(cascade = CascadeType.MERGE)
	@JoinColumn(name = "account_transaction",columnDefinition = "INT(100) default '1'")
	private List<Transaction> transactions;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerAccount",nullable = true)
	private Customer customer;
	

	public boolean getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(boolean accountStatus) {
		this.accountStatus = accountStatus;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public LocalDate getOpenDate() {
		return openDate;
	}

	public void setOpenDate(LocalDate openDate) {
		this.openDate = openDate;
	}

	public double getBalance() {
		return balance;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void addtransaction(Transaction t) {
		transactions.add(t);
	}

	@Override
	public String toString() {
		return "Account [AccountId=" + "AccountId" + ", accountNumber=" + accountNumber + ", accountHolderName="
				+ accountHolderName + ", accountType=" + accountType + ", openDate=" + openDate + ", accountStatus="
				+ accountStatus + ", balance=" + balance + ", transactions=" + transactions + ", customer=" + customer
				+ "]";
	}

}
