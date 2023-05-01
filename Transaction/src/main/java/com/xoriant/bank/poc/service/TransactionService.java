package com.xoriant.bank.poc.service;

import java.time.LocalDate;
import java.util.List;
import com.xoriant.bank.poc.entity.Transaction;

public interface TransactionService {
	
	public	String withdrawMoney(int accountno,double withdrawamount,int from);

	public	String DepositMoney(int accountno,double depositeamount,int from);

	public	List<Transaction> MiniStatement(int accountNumber);

	public	List<Transaction> CustomizedMiniStatement(LocalDate localdate,int transactiovalue);

	public String fundTransfer(int from,int to,double amount); 

	public	double checkBalance(int account);


}
