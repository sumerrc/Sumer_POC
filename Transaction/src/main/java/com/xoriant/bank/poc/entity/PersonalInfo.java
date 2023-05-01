package com.xoriant.bank.poc.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.lang.NonNull;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class PersonalInfo {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int personId;
private String name;
private LocalDate dateOfBirth;
@Enumerated(EnumType.STRING)
private Gender gender;
private String emailId;
@Embedded
private Address address;
private long mobileNumber;
@OneToOne
@JoinColumn(name = "userId")
private User user;
public int getPersonId() {
	return personId;
}
public void setPersonId(int personId) {
	this.personId = personId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public LocalDate getDateOfBirth() {
	return dateOfBirth;
}
public void setDateOfBirth(LocalDate dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}
public Gender getGender() {
	return gender;
}
public void setGender(Gender gender) {
	this.gender = gender;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
public long getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(long mobileNumber) {
	this.mobileNumber = mobileNumber;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}

}
