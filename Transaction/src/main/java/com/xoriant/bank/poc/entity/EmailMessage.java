package com.xoriant.bank.poc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class EmailMessage {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int emailId;
private String messageId;
private String subject;
private String messageDescription;
private String recepientMailId;
public String getMessageId() {
	return messageId;
}
public void setMessageId(String messageId) {
	this.messageId = messageId;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public String getMessageDescription() {
	return messageDescription;
}
public void setMessageDescription(String messageDescription) {
	this.messageDescription = messageDescription;
}
public String getRecepientMailId() {
	return recepientMailId;
}
public void setRecepientMailId(String recepientMailId) {
	this.recepientMailId = recepientMailId;
}

}
