package com.xoriant.bank.poc.dao;

import org.springframework.data.repository.CrudRepository;

import com.xoriant.bank.poc.entity.Customer;

public interface CustomerDao extends CrudRepository<Customer,Integer>{

}
