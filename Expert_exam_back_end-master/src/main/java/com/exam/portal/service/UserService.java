package com.exam.portal.service;

import java.util.Set;

import com.exam.portal.entity.UserRole;
import com.exam.portal.entity.Users;

public interface UserService {

	public Users createUser(Users user,Set<UserRole> userRole) throws Exception;
	
	public Users getUser(String userName);

	void deleteUser(int userId);
}
