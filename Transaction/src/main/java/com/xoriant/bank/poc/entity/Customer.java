package com.xoriant.bank.poc.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Customer extends PersonalInfo {
	
	@OneToMany(cascade = CascadeType.REFRESH,mappedBy = "customer")
	private List<Account> accounts;	
	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "branchId")
	private Branch branch;

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	
}
