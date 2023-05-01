package com.xoriant.bank.poc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Branch {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int branchId;
private String branchName;
private String address;
private String ifscCode;
private long micrNo;
public int getBranchId() {
	return branchId;
}
public void setBranchId(int branchId) {
	this.branchId = branchId;
}
public String getBranchName() {
	return branchName;
}
public void setBranchName(String branchName) {
	this.branchName = branchName;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getIfscCode() {
	return ifscCode;
}
public void setIfscCode(String ifscCode) {
	this.ifscCode = ifscCode;
}
public long getMicrNo() {
	return micrNo;
}
public void setMicrNo(long micrNo) {
	this.micrNo = micrNo;
}

}
