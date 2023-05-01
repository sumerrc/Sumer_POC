package com.xoriant.bank.poc.dao;

import org.springframework.data.repository.CrudRepository;

import com.xoriant.bank.poc.entity.Transaction;

public interface TransactionDao extends CrudRepository<Transaction , Integer>{

}
