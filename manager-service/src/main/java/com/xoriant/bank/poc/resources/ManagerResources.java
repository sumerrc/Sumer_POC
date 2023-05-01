	package com.xoriant.bank.poc.resources;

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
import com.xoriant.bank.poc.service.ManagerService;
import com.xoriant.bank.poc.util.UserFient;

@RestController
@RequestMapping("/api/manager/filter")
public class ManagerResources{

	@Autowired
	ManagerService managerService;	
	
	@Autowired
	RestTemplate restTemplate;
	
	
	@PostMapping("/addbranch")
	public String addNewBranch(@RequestBody Branch branch) {
	
		return managerService.addNewBranch(branch);
	}
	@PostMapping("/addperson")
	public String addNewPerson(@RequestBody PersonalInfo personInfo) {
		System.out.println("hello");
		return managerService.addNewPerson(personInfo);
	}
	

	
	@GetMapping("/getbalance/{accountno}")
	public double getbalance(@PathVariable int	accountno) {
		
		return managerService.checkBalance(accountno);
	}
	@GetMapping("/withdraw/{accountno}/{amount}/{from}")
	public String withdraw(@PathVariable Integer accountno,Double amount,Integer from) {
		

		
		String url="http://localhost:8082/api/filter/withdraw/"+accountno+"/"+amount+"/"+from+"";
		String withdrawamount2=restTemplate.getForObject(url,String.class);
		return withdrawamount2;
		
//		return managerService.withdrawMoney(accountno,accountno,from);
	}
	@GetMapping("/deposite/{accountno}/{amount}/{from}")
	public String deposite(@PathVariable Integer accountno,Double amount,Integer from) {
		
		String deposite=restTemplate.getForObject("http://localhost:8082/api/filter/deposite/123465/50000/123",String.class);
		
		return deposite;
		
//		return managerService.DepositMoney(accountno,accountno,from);
	}
	
	
	@PutMapping("/updateperson/{accountno}")
	public String updatePersonInfo(@PathVariable int accountno,@RequestBody PersonalInfo personInfo) {
		System.out.println("updating person info");
		return managerService.updateCustomer(accountno,personInfo);
	}
	
	@DeleteMapping("/deletePerson/{personId}")
	public String deletePersonInfo(@PathVariable int personId) {
		
		return managerService.deletePerson(personId);
		
	}

	@GetMapping("/checkPerson/{personId}")
	public String checkPerson(@PathVariable int personId) {

		boolean check = managerService.checkPerson(personId);
		if (check) {
			System.out.println("This person is already present in database");
			return "This person is already present in database";
		} else {
			System.out.println("This person is not present");
			return "This person is not present";
		}
		
	}
	@PostMapping("/addAccount")
	public String addAccount(@RequestBody Account account) {
		
		return managerService.addAccount(account);
		
	}
	
	@GetMapping("/changePassword/{email}/{mobileno}/{password}")
	public String changePassword(@PathVariable String email,@PathVariable Long mobileno,@PathVariable String password) {
				
	String 	message=managerService.changePassword(email,mobileno,password);
	
	return message;
	}
	
	@GetMapping("/allAccounts")
	public Iterable<Account> allAccounts(){
		
		return managerService.findAccountDetails();
		
	}
	
	@GetMapping("/fundTransfer/{fromAccount}/{toAccount}/{amount}")
	public String fundTransfer(@PathVariable int fromAccount,@PathVariable int toAccount,@PathVariable double amount) {
		
		String message= managerService.fundTransfer(fromAccount, toAccount, amount);

		return message;
	}
	@PutMapping("/updateAccount/{accountno}")
	public String updateAccount(@PathVariable int accountno,@RequestBody Account account) {
		System.out.println("updating Account info");
		return managerService.updateAccount(accountno,account);
	}
	@PutMapping("/deleteAccount/{accountno}")
	public String deleteAccount(@PathVariable int accountno) {
		System.out.println("deleting Account info");
		return managerService.deleteAccount(accountno);
	}
	
}
