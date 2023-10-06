package com.exam.portal.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class UserRole {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int userRoleId;
	
@ManyToOne(fetch =FetchType.EAGER)
private Users users;

@ManyToOne(fetch = FetchType.EAGER)
private Role role;

public int getUserRoleId() {
	return userRoleId;
}
public void setUserRoleId(int userRoleId) {
	this.userRoleId = userRoleId;
}
public Users getUsers() {
	return users;
}
public void setUsers(Users users) {
	this.users = users;
}
public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}
public UserRole() {
}

}
