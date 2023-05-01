package com.xoriant.bank.poc.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
private  int flatNumber;
private String flatName;
private String streetName;
private String city;
private String state;
private int pinCode;

public int getFlatNumber() {
	return flatNumber;
}
public void setFlatNumber(int flatNumber) {
	this.flatNumber = flatNumber;
}
public String getFlatName() {
	return flatName;
}
public void setFlatName(String flatName) {
	this.flatName = flatName;
}
public String getStreetName() {
	return streetName;
}
public void setStreetName(String streetName) {
	this.streetName = streetName;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public int getPinCode() {
	return pinCode;
}
public void setPinCode(int pinCode) {
	this.pinCode = pinCode;
}

}
