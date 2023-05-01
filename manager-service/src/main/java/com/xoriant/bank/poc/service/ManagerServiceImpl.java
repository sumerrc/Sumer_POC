package com.xoriant.bank.poc.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.xoriant.bank.poc.dao.AccountDao;
import com.xoriant.bank.poc.dao.BranchDao;
import com.xoriant.bank.poc.dao.ManagerDao;
import com.xoriant.bank.poc.dao.PersonalInfoDao;
import com.xoriant.bank.poc.dao.UserDao;
import com.xoriant.bank.poc.entity.Account;
import com.xoriant.bank.poc.entity.Branch;
import com.xoriant.bank.poc.entity.PersonalInfo;
import com.xoriant.bank.poc.entity.Transaction;
import com.xoriant.bank.poc.util.TransactionFient;
import com.xoriant.bank.poc.util.UserFient;

@Service
public class ManagerServiceImpl implements ManagerService{
	
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

	@Autowired(required = false)
	TransactionFient transactionFient;
	
	@Autowired(required = false)
	UserFient userFient;
	
	@Override
	public String addNewBranch(Branch branch) {
		
		branchDao.save(branch);
		
		return "Branch added succefully";
	
	}

	@Override
	public String addNewPerson(PersonalInfo personInfo) {
		
		personalInfoDao.save(personInfo);
		
		return "Person added successfully";
	}

	@Override
	public String updateCustomer(int accountNumber, PersonalInfo personInfo) {
		
		Iterable<Account>acc=accountDao.findAll();
		for (Account account : acc) {
			if(account.getAccountNumber()==accountNumber) {
				
			Iterable<PersonalInfo>person=personalInfoDao.findAll();
			
			for (PersonalInfo person1 : person) {
				
				if(account.getCustomer().getPersonId()==person1.getPersonId()) {
					
					person1.setName(personInfo.getName());
					person1.setAddress(personInfo.getAddress());
					person1.setDateOfBirth(personInfo.getDateOfBirth());
					person1.setEmailId(personInfo.getEmailId());
					person1.setGender(personInfo.getGender());
					person1.setMobileNumber(personInfo.getMobileNumber());
					person1.setPersonId(personInfo.getPersonId());
					person1.setUser(personInfo.getUser());
	
					personalInfoDao.save(person1);
					
				}
			}	
			}		
		}	
		return "person info updated succefully";
	}

	@Override
	public int getPersonId(int accountno) {
		
		int personid=0;
		Iterable<Account>acc=accountDao.findAll();
		for (Account account : acc) {
			
			if(account.getAccountNumber()==accountno) {
				
				personid=account.getCustomer().getPersonId();
			}
		}
		
		
		
		return personid;
	}

	@Override
	public Boolean checkPerson(int PersonId) {
			
		Optional<PersonalInfo> personalInfo=personalInfoDao.findById(PersonId);
		if(personalInfo!=null) {
		return true;
		}{
			return false;
		}
	}

	@Override
	public String deletePerson(int personid) {
		
		personalInfoDao.deleteById(personid);
		
		return "Person delted successfully";
	}
	@Transactional
	@Override
	public String addAccount(Account account) {
		
		accountDao.save(account);
		return "Account added succesfully";
	}

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
	public String withdrawMoney(int accontno,int amount,int from) {
		
		return transactionFient.withdrawMoney(amount, amount, from);
		
	}

	@Override
	public String DepositMoney(int accontno,int amount,int from) {
		
		return transactionFient.DepositMoney(amount, amount, from);
	}

	@Override
	public List<Transaction> CustomizedMiniStatement(int accountNumber, double amount, String fromdate, String toDate) {
		
		return null;
	}

	
	@Override
	public List<Transaction> MiniStatement(int accountNumber) {
	
		return transactionFient.miniStatement(accountNumber);
	}

	@Override
	public Iterable<Account> findAccountDetails() {
	
		Iterable<Account> accounts=accountDao.findAll();
		return accounts;
	}

	public String DepositMoney(@PathVariable int accountNumber,@PathVariable double amount,@PathVariable int from) {
		
	String s= transactionFient.DepositMoney(accountNumber,amount,from);
		 
	System.out.println(s);
	
		return "deposited";
	}
	
	public String withdrawMoney(@PathVariable int accountNumber,@PathVariable double amount,@PathVariable int from) {
		
	String s= transactionFient.withdrawMoney(accountNumber,amount,from);
		 
	System.out.println(s);
		 return "withdraw";
	}

	
	public List<Transaction>miniStatement(@PathVariable int accountNumber) {
		
		List<Transaction> transactions= transactionFient.miniStatement(accountNumber);
		 
		System.out.println(transactions);
		 return transactions;
	}

	@Override
	public String fundTransfer(int from, int to, double amount) {
		
		return transactionFient.fundTransfer(from, to, amount);
	}

	@Override
	public String updateAccount(int accountNumber, Account account) {
		
		Iterable<Account>accounts=accountDao.findAll();
		for (Account Acc : accounts) {
	
	if(accountNumber==Acc.getAccountNumber()) {
		
		Acc.setAccountHolderName(account.getAccountHolderName());
		Acc.setAccountNumber((int)account.getAccountNumber());
		Acc.setAccountStatus(account.getAccountStatus());
		Acc.setAccountType(account.getAccountType());
		Acc.setOpenDate(account.getOpenDate());
		Acc.setTransactions(account.getTransactions());
		Acc.setCustomer(account.getCustomer());
		
		accountDao.save(Acc);
		
	}
}
		
		return "Account updated succesfully";
	}

	@Override
	public String deleteAccount(int accountNumber) {
		
		Iterable<Account>accounts=accountDao.findAll();
		for (Account Acc : accounts) {
			
			if(accountNumber==Acc.getAccountNumber()) {
				
				accountDao.deleteById(Acc.getAccountId());
				
			}
		}
	
		 return "Account deleted succesfully";
	}
	
	
	}
