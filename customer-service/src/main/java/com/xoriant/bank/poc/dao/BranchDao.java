package com.xoriant.bank.poc.dao;

import org.springframework.data.repository.CrudRepository;

import com.xoriant.bank.poc.entity.Branch;

public interface BranchDao extends CrudRepository<Branch, Integer>{

	
}
