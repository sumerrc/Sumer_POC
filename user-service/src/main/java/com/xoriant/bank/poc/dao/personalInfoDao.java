package com.xoriant.bank.poc.dao;

import org.springframework.data.repository.CrudRepository;

import com.xoriant.bank.poc.entity.PersonalInfo;

public interface personalInfoDao extends CrudRepository<PersonalInfo, Integer>{

}
