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
		return new Queue("WithdrawEmailQ", false);
	}
	
	@Bean
	@Lazy(value = false)
	public Queue f2() {
		return new Queue("DepositeEmailQ", false);
	}
	
	@Bean
	@Lazy(value = false)
	public Queue f3() {
		return new Queue("FundTransferEmailQ", false);
	}
	
	@Bean
	@Lazy(value = false)
	public Queue f4() {
		return new Queue("BalanceCheckEmailQ", false);
	}
	
	public void sendWithdrawDetails(double amount) {
		String msg=amount+" Rs. amount is withdraw from your account";
		rabbitTemplate.convertAndSend("WithdrawEmailQ",msg);
	}
		
	public void sendDepositeDetails(double amount) {
			String msg=amount+" Rs. amount is deposited in your account.";
			rabbitTemplate.convertAndSend("DepositeEmailQ",msg);
	}		
	public void sendFundTransaferDetails(double amount , int accountdetails) {
				String msg=amount+" Rs. amount is transfer from your account to "+accountdetails;
				rabbitTemplate.convertAndSend("FundTransferEmailQ",msg);		

	}
	public void balanceInquiry(double amount) {
		String msg="Your balnace is : "+amount;
		rabbitTemplate.convertAndSend("BalanceCheckEmailQ",msg);		

	}
	
}
