package com.xoriant.bank.poc.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.xoriant.bank.poc.entity.Account;

@Repository
public interface AccountDao extends CrudRepository<Account,Integer>{

	void deleteByAccountNumber(int accountNumber);

}
