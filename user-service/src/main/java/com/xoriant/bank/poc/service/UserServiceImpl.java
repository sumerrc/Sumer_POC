package com.xoriant.bank.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.bank.poc.dao.UserDao;
import com.xoriant.bank.poc.dao.personalInfoDao;
import com.xoriant.bank.poc.entity.PersonalInfo;
import com.xoriant.bank.poc.entity.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	personalInfoDao personalInfoDao; 
	
	@Override
	public String changePassword(String email, Long mobileno, String password) {
		
	Iterable<PersonalInfo> personalInfo=personalInfoDao.findAll();
		
		for (PersonalInfo info : personalInfo) {
			
			if(info.getEmailId().equals(email) && info.getMobileNumber()==mobileno) {
				
			Iterable<User> user=userDao.findAll();
			
			for (User userinfo : user) {
				
				if(userinfo.getUserId()==info.getUser().getUserId()) {
					userinfo.setPassword(password);
					userDao.save(userinfo);
				}
			}
			
			
			}
		}
		
		return "Password change successfully";
	}
	
}
