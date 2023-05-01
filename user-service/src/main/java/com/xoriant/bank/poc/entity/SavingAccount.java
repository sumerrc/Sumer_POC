package com.xoriant.bank.poc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SavingAccount extends Account {

	
private double dailyLimitAmount;
private int dailyLimitNoOFTransaction;
public double getDailyLimitAmount() {
	return dailyLimitAmount;
}
public void setDailyLimitAmount(double dailyLimitAmount) {
	this.dailyLimitAmount = dailyLimitAmount;
}
public int getDailyLimitNoOFTransaction() {
	return dailyLimitNoOFTransaction;
}
public void setDailyLimitNoOFTransaction(int dailyLimitNoOFTransaction) {
	this.dailyLimitNoOFTransaction = dailyLimitNoOFTransaction;
}


}
