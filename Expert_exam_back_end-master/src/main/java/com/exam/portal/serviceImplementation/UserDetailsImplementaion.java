package com.exam.portal.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exam.portal.entity.Users;
import com.exam.portal.repository.UsersRepo;

@Service
public class UserDetailsImplementaion implements UserDetailsService{

	@Autowired
	UsersRepo usersRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("-----------------------------------"+usersRepo.findByUserName(username));
		Users user=usersRepo.findByUserName(username);

		if(user==null) {
			System.out.println("User not found");
            throw new UsernameNotFoundException("No user found !!");
		}
		UsersDetails userdetail=new UsersDetails(user);
		
		return userdetail;
	}

}
