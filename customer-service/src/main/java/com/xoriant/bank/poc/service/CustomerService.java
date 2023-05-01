package com.xoriant.bank.poc.service;

import java.util.List;


import com.xoriant.bank.poc.entity.Transaction;

public interface CustomerService {
	
	
	public double checkBalance(int accountNumber);

	String changePassword(String email, Long mobileno,String password);
	
	public List<Transaction> CustomizedMiniStatement(int accountNumber, double amount, String fromdate,
		String toDate);

	public String fundTransfer(int from ,int to,double amount);
	

	String DepositMoney(int accountNumber, double amount, int from);

	List<Transaction> miniStatement(int accountNumber);

	String withdrawMoney(int accountNumber, double amount, int from);





	


}
