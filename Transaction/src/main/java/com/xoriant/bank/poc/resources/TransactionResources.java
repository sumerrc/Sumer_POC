package com.xoriant.bank.poc.resources;

import java.util.List;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xoriant.bank.poc.entity.Transaction;
import com.xoriant.bank.poc.service.TransactionService;

@RestController
@RequestMapping("/api/filter")
public class TransactionResources {
	

	@Autowired
	TransactionService transactionService;	
	
	@Autowired
	MailService mailService;
	
	@GetMapping("/deposite/{accountNumber}/{amount}/{from}")
	public String DepositMoney(@PathVariable Integer accountNumber,@PathVariable Double amount,@PathVariable Integer from) {
		
	String s= transactionService.DepositMoney(accountNumber,amount,from);
		
	mailService.sendDepositeDetails(amount);
	System.out.println(s);
	
	
		return "deposited";
	}
	@GetMapping("/withdraw/{accountNumber}/{amount}/{from}")
	public String withdrawMoney(@PathVariable Integer accountNumber,@PathVariable Double amount,@PathVariable Integer from) {
		
	String s= transactionService.withdrawMoney(accountNumber,amount,from);
	mailService.sendWithdrawDetails(amount);
	System.out.println(s);
	return "withdraw";
	}
	@GetMapping("/checkbalance/{accountNumber}")
	public double checkBalance(@PathVariable int accountNumber) {
		
		double balance= transactionService.checkBalance(accountNumber);
		mailService.balanceInquiry(balance); 
		System.out.println(balance);
		 return balance;
	}
	@GetMapping("/ministatement/{accountNumber}")
	public List<Transaction>miniStatement(@PathVariable int accountNumber) {
		
		List<Transaction> transactions= transactionService.MiniStatement(accountNumber);
		 
		System.out.println(transactions);
		 return transactions;
	}
	@GetMapping("/fundTransafer/{fromAccount}/{toAccount}/{amount}")
	public String fundTransfer(@PathVariable int fromAccount,@PathVariable int toAccount,@PathVariable double amount) {
		
		String message= transactionService.fundTransfer(fromAccount, toAccount, amount);
		mailService.sendFundTransaferDetails(amount, toAccount);
		
		return message;
	}
	
	
}
