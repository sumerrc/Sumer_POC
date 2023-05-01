package com.xoriant.bank.poc.service;

import java.util.List;
import com.xoriant.bank.poc.entity.Account;
import com.xoriant.bank.poc.entity.Branch;
import com.xoriant.bank.poc.entity.PersonalInfo;
import com.xoriant.bank.poc.entity.Transaction;
import com.xoriant.bank.poc.entity.User;

public interface ManagerService {
	
	String addNewBranch(Branch branch);

	String addNewPerson(PersonalInfo personInfo);
	
	public double checkBalance(int accountNumber);

	public String withdrawMoney(int accountno,int amount,int from);

	public String DepositMoney(int accountno,int amount,int from);

	public String updateCustomer(int accountNumber, PersonalInfo personInfo);

	int getPersonId(int customer_id);

	Boolean checkPerson(int personId);

	String deletePerson(int personid);

	String changePassword(String email, Long mobileno,String password);
	
	public List<Transaction> CustomizedMiniStatement(int accountNumber, double amount, String fromdate,
		String toDate);

	public String fundTransfer(int from ,int to,double amount);
	
	public List<Transaction> MiniStatement(int accountNumber);

	public Iterable<Account> findAccountDetails();
	String addAccount(Account account);
	
	String updateAccount( int accountNumber, Account account);

	String deleteAccount(int accountNumber);
	


}
