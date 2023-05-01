package com.xoriant.bank.poc.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;

@Controller
public class EmailResources {
	
	@Autowired
	private JavaMailSender javaMailSender;

	@RabbitListener(queues = "PasswordChangeEmailQ")
	public void balanceInquiry(String bankMsg) {
		
	        SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo("mayurimestry46@gmail.com");    
	        msg.setSubject("Your Password Has Changed");
	        msg.setText(bankMsg);
	        javaMailSender.send(msg);
	        System.out.println("Password has Succesfully changed");
	}
	
	@RabbitListener(queues = "WithdrawEmailQ")
	public void withdraw(String bankMsg) {

			System.out.println(bankMsg);

	        SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo("mayurimestry46@gmail.com");   
	        msg.setSubject("Withdraw Amount from your Account");
	        msg.setText(bankMsg);
	        javaMailSender.send(msg);
	        System.out.println("Amount has been succesfully withdraw");
	}
	
	@RabbitListener(queues = "DepositeEmailQ")
	public void deposite(String bankMsg) {
		
			System.out.println(bankMsg);
	        SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo("mayurimestry46@gmail.com");	    
	        msg.setSubject("Deposited Amount Successfully in your Account");
	        msg.setText(bankMsg);
	        javaMailSender.send(msg);
	        System.out.println("Amount Has Successfully Deposited");
	        
	}
	
	@RabbitListener(queues = "FundTransferEmailQ")
	public void fundtransfer(String bankMsg) {
			System.out.println(bankMsg);
	        SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo("mayurimestry46@gmail.com");    
	        msg.setSubject("Fund Transfer Successfully");
	        msg.setText(bankMsg);
	        javaMailSender.send(msg);     
	        System.out.println("Fund Has been Successfully Transfered");
	        
	}
	@RabbitListener(queues = "BalanceCheckEmailQ")
	public void BalaceCheck(String bankMsg) {
		System.out.println(bankMsg);
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("mayurimestry46@gmail.com");    
        msg.setSubject("Regarding balance check");
        msg.setText(bankMsg);
        javaMailSender.send(msg);     
        System.out.println("Balance Check has been done");
        
}

}
