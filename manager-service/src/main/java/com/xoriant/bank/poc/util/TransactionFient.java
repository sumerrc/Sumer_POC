package com.xoriant.bank.poc.util;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.xoriant.bank.poc.entity.Transaction;

@FeignClient(name = "transaction-service",url="http://localhost:8082/api/filter")
public interface TransactionFient {
	
	@GetMapping("/deposite/{accountNumber}/{amount}/{from}")
	public String DepositMoney(@PathVariable int accountNumber,@PathVariable double amount,@PathVariable int from);
	
	@GetMapping("/withdraw/{accountNumber}/{amount}/{from}")
	public String withdrawMoney(@PathVariable int accountNumber,@PathVariable double amount,@PathVariable int from);
		
	@GetMapping("/checkbalance/{accountNumber}")
	public double checkBalance(@PathVariable int accountNumber);
	
	@GetMapping("/ministatement/{accountNumber}")
	public List<Transaction>miniStatement(@PathVariable int accountNumber);
	
	@GetMapping("/fundTransafer/{fromAccount}/{toAccount}/{amount}")
	public String fundTransfer(@PathVariable int fromAccount,@PathVariable int toAccount,@PathVariable double amount); 
	

}
