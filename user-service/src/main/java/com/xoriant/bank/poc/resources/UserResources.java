package com.xoriant.bank.poc.resources;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xoriant.bank.poc.dao.UserDao;
import com.xoriant.bank.poc.service.UserService;

@RestController
@RequestMapping("/api/filter")
public class UserResources{

	@Autowired
	UserService userService;
		
	@Autowired
	UserDao userDao;
	
	@Autowired
	MailService mailService;

	
	@GetMapping("/changePassword/{email}/{mobileno}/{password}")
	public String changePassword(@PathVariable String email,@PathVariable Long mobileno,@PathVariable String password) {
		
	mailService.passwordChangeDetails(password);
	
	return 	userService.changePassword(email, mobileno, password);
	}
	
	
	
}
