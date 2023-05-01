package com.xoriant.bank.poc.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Manager extends PersonalInfo{
	
	
	@OneToMany(cascade = CascadeType.REFRESH)
private List<Customer> customers;
	
	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "branchId")
private Branch branch;

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}


}
