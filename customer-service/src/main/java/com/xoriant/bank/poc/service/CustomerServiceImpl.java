package com.xoriant.bank.poc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.xoriant.bank.poc.dao.AccountDao;
import com.xoriant.bank.poc.dao.BranchDao;
import com.xoriant.bank.poc.dao.ManagerDao;
import com.xoriant.bank.poc.dao.PersonalInfoDao;
import com.xoriant.bank.poc.dao.TransactionDao;
import com.xoriant.bank.poc.dao.UserDao;
import com.xoriant.bank.poc.entity.Transaction;
import com.xoriant.bank.poc.util.TransactionFient;
import com.xoriant.bank.poc.util.UserFient;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	ManagerDao managerDao;
	
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	BranchDao branchDao;
	
	@Autowired
	PersonalInfoDao personalInfoDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	RestTemplate restTemplate;

	@Autowired(required = false)
	TransactionFient transactionFient;
	
	@Autowired(required = false)
	UserFient userFient;
	
	

	@Override
	public String changePassword(String email,Long mobileno,String password) {
		
		String message=userFient.changePassword(email, mobileno, password);
		return message;
		
	}

	@Override
	public double checkBalance(int accountNumber) {
		
		double balance= transactionFient.checkBalance(accountNumber);
		return balance;
	}

	@Override
	public List<Transaction> CustomizedMiniStatement(int accountNumber, double amount, String fromdate, String toDate) {
		
		return null;
	}

	

@Override
	public String DepositMoney(@PathVariable int accountNumber,@PathVariable double amount,@PathVariable int from) {
		
//	String deposite=restTemplate.getForObject("http://localhost:8082/api/filter/deposite/123465/50000/123",String.class);
	
//	return deposite;
	
	String s= transactionFient.DepositMoney(accountNumber,amount,from);
		 
	System.out.println(s);
	
		return "deposited";
	}
	@Override
	public String withdrawMoney(@PathVariable int accountNumber,@PathVariable double amount,@PathVariable int from) {
		
//		Map<String, Integer>map1=new HashMap<>();
//		map1.put("accountno", accountno);
//		map1.put("from", from);
//		Map<String, Double>map2=new HashMap<>();
//		map2.put("amount", amount);
		
		String url="http://localhost:8082/api/filter/withdraw/"+accountNumber+"/"+amount+"/"+from+"";
		String withdrawamount=restTemplate.getForObject(url,String.class);
		
		
//		String url="http://localhost:8082/api/filter/withdraw/"+accountno+"/"+amount+"/"+from+"";
//		String withdrawamount2=restTemplate.getForObject(url,String.class);
//		return withdrawamount2;
//	String s= transactionFient.withdrawMoney(accountNumber,amount,from);
		 
//	System.out.println(s);
		 return "withdraw";
	}

	@Override
	public List<Transaction>miniStatement(@PathVariable int accountNumber) {
		
		List<Transaction> transactions= transactionFient.miniStatement(accountNumber);
		 
		System.out.println(transactions);
		 return transactions;
	}

	@Override
	public String fundTransfer(int from, int to, double amount) {
		
		return transactionFient.fundTransfer(from, to, amount);
	}


	}
