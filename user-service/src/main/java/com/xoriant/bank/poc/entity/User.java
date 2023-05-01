package com.xoriant.bank.poc.entity;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class User {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int userId;
private String Username;
private String password;

@Enumerated(EnumType.STRING)
private Role role;

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public String getUsername() {
	return Username;
}

public void setUsername(String username) {
	Username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public Role getRole() {
	return role;
}

public void setRole(Role role) {
	this.role = role;
}

}
