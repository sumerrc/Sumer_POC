package com.xoriant.bank.poc.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xoriant.bank.poc.dao.AccountDao;
import com.xoriant.bank.poc.dao.TransactionDao;
import com.xoriant.bank.poc.entity.Account;
import com.xoriant.bank.poc.entity.Transaction;
import com.xoriant.bank.poc.entity.TransactionType;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	TransactionDao transactionDao;
	
	@Autowired
	AccountDao accountDao;
		
	@Override
	public String DepositMoney(int accountno, double depositeamount,int from) {
		
		Iterable<Account> ac=accountDao.findAll();
		Transaction t=new Transaction();
		for (Account account : ac) {
			
			if(account.getAccountNumber()==accountno);
			{
				System.out.println(ac);
				double newamount=account.getBalance()+depositeamount;
				System.out.println(newamount);
				account.setBalance(newamount);
				accountDao.save(account);
				t.setToAccount(account);	
				t.setTransactionDescription("deposite to:-"+account.getAccountNumber());		
				t.setTransactionDate(LocalDate.now());
				t.setTransactionType(TransactionType.DEPOSIT);
				t.setTransactionAmount(depositeamount);
				t.setFromAccount(account);
				transactionDao.save(t);
			
			}
		}
		return "money_deposited_successfully";
	}

	@Override
	public List<Transaction> MiniStatement(int accountNumber) {
		List<Transaction>transaction=new ArrayList<Transaction>();
      Iterable<Account> ac=accountDao.findAll();
//		
//	Iterable<Transaction>tra=transactionDao.findAll();
//	for (Transaction transaction2 : tra) {
//		
//		System.out.println(transaction2.toString());
//	}
//		
		
		
		for (Account account : ac) {
			
			if (accountNumber==account.getAccountNumber()) {
				
				transaction.add((Transaction) account.getTransactions());
				
				
				System.out.println(transaction);
				
//				int size=account.getTransactions().size();
//				
//				account.getTransactions().forEach(System.out::println);
//				
//				int start=size-5;
//				
//				for(int i=start;i>0;i++) {
//					
//					transaction=account.getTransactions();
//					
//					
//				}
				
			}
		}
		return transaction;
	}

	@Override
	public List<Transaction> CustomizedMiniStatement(LocalDate localdate, int transactiovalue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double checkBalance(int accountno) {
		
		Iterable<Account> ac=accountDao.findAll();
		
		double balance=0;
		
		for (Account account : ac) {
			
			if(accountno==account.getAccountNumber()) {
				
				System.out.println();
				System.out.println(account.getBalance());
				balance=account.getBalance();
				
			}
		}	
		return balance;
		
	}


	@Override
	public String withdrawMoney(int accountno, double withdrawamount, int from) {
		Iterable<Account> ac=accountDao.findAll();
		Transaction t=new Transaction();
		for (Account account : ac) {
			
			if(account.getAccountNumber()==accountno);
			{
				System.out.println(ac);
				double newamount=(account.getBalance()-withdrawamount);
				System.out.println(newamount);
				account.setBalance(newamount);
				accountDao.save(account);
				t.setToAccount(account);	
				t.setTransactionDescription("withdraw to:-"+account.getAccountNumber());		
				t.setTransactionDate(LocalDate.now());
				t.setTransactionType(TransactionType.DEPOSIT);
				t.setTransactionAmount(withdrawamount);
				t.setFromAccount(account);
				transactionDao.save(t);

			}

		
	}
		return "successfully withdrawal of amount";
	}

	@Override
	public String fundTransfer(int fromAccount, int toAccount, double amount) {
		
		Iterable<Account> accounts = accountDao.findAll();

		for (Account account : accounts) {

			if (account.getAccountNumber() == fromAccount) {

				double finalamount = account.getBalance() - amount;
				account.setBalance(finalamount);
				accountDao.save(account);

			}
			if (account.getAccountNumber() == toAccount) {

				double finalamount = account.getBalance() + amount;
				account.setBalance(finalamount);
				accountDao.save(account);

			}
		}

	return "Amount transafer succesfully";
	}
	}
