package com.xoriant.bank.poc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class CurrentAccount extends Account{

private double minimumBalance;
private String companyName;
public double getMinimumBalance() {
	return minimumBalance;
}
public void setMinimumBalance(double minimumBalance) {
	this.minimumBalance = minimumBalance;
}
public String getCompanyName() {
	return companyName;
}
public void setCompanyName(String companyName) {
	this.companyName = companyName;
}



}
