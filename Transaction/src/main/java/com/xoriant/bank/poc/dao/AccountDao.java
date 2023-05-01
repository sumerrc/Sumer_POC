package com.xoriant.bank.poc.dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.xoriant.bank.poc.entity.Account;
@Repository
public interface AccountDao extends CrudRepository<Account,Integer>{

	Account findByAccountId(int accountno);
//	@Modifying(flushAutomatically = true,clearAutomatically = true)
//	@Transactional
//	@Query(nativeQuery = true,value="update account set balance=?1 where account_number=?2")
//	void updatebalance(double balance,double account_number);


//	Account findbyAccountNumber(int id);
	

}
