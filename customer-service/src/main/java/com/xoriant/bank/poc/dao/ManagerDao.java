package com.xoriant.bank.poc.dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.xoriant.bank.poc.entity.Manager;
import com.xoriant.bank.poc.entity.Transaction;

@Repository
public interface ManagerDao extends CrudRepository<Manager,Integer>{


	
}
