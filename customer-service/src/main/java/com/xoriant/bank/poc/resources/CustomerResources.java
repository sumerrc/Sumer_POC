package com.xoriant.bank.poc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.xoriant.bank.poc.entity.Account;
import com.xoriant.bank.poc.entity.Branch;
import com.xoriant.bank.poc.entity.PersonalInfo;
import com.xoriant.bank.poc.entity.Transaction;
import com.xoriant.bank.poc.service.CustomerService;

@RestController
@RequestMapping("/api/customer/filter")
public class CustomerResources{

	@Autowired
	CustomerService customerService;	

	
	@GetMapping("/getbalance/{accountno}")
	public double getbalance(@PathVariable int	accountno) {
		
		return customerService.checkBalance(accountno);
	}
	@GetMapping("/withdraw/{accountno}/{amount}/{from}")
	public String withdraw(@PathVariable Integer accountno,@PathVariable Double amount,@PathVariable Integer from) {
		

		
		return customerService.withdrawMoney(accountno,accountno,from);
	}
	@GetMapping("/deposite/{accountno}/{amount}/{from}")
	public String deposite(@PathVariable Integer accountno,Double amount,Integer from) {
		

		return customerService.DepositMoney(accountno.intValue(),accountno.intValue(),from.intValue());
	}
	

	
	@GetMapping("/changePassword/{email}/{mobileno}/{password}")
	public String changePassword(@PathVariable String email,@PathVariable Long mobileno,@PathVariable String password) {
				
	String 	message=customerService.changePassword(email,mobileno,password);
	
	return message;
	}
	
	
	@GetMapping("/fundtransfer/{fromAccount}/{toAccount}/{amount}")
	public String fundTransfer(@PathVariable int fromAccount,@PathVariable int toAccount,@PathVariable double amount) {
		
		String message= customerService.fundTransfer(fromAccount, toAccount, amount);

		return message;
	}

	@GetMapping("/ministatement/{accountno}")
	public List<Transaction>getMiniStatement(@PathVariable int accountno){
		
		return	customerService.miniStatement(accountno);
		
	}
	
}
