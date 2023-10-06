package com.exam.portal.entity;

import java.util.HashSet;
import java.util.Set;


import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int roleId;
private String role;

@jakarta.persistence.OneToMany(fetch = jakarta.persistence.FetchType.EAGER,cascade = jakarta.persistence.CascadeType.ALL)
private Set<UserRole> userRole=new HashSet<>();

public int getRoleId() {
	return roleId;
}
public void setRoleId(int roleId) {
	this.roleId = roleId;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public Set<UserRole> getUserRole() {
	return userRole;
}
public void setUserRole(Set<UserRole> userRole) {
	this.userRole = userRole;
}


}
