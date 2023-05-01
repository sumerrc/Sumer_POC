package com.xoriant.bank.poc.dao;

import org.springframework.data.repository.CrudRepository;

import com.xoriant.bank.poc.entity.User;

public interface UserDao extends CrudRepository<User, Integer> {

	
}
