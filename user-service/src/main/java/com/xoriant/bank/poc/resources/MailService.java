package com.xoriant.bank.poc.resources;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class MailService {

	@Autowired
	RabbitTemplate rabbitTemplate;
	
	@Bean
	@Lazy(value = false)
	public Queue f1() {
		return new Queue("PasswordChangeEmailQ", false);
	}

	
	public void passwordChangeDetails(String password) {
		String msg="Your new Password is : "+password;
		rabbitTemplate.convertAndSend("PasswordChangeEmailQ",msg);		

	}
	
}
