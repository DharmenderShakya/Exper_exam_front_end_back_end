package com.exam.portal;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.exam.portal.entity.Role;
import com.exam.portal.entity.UserRole;
import com.exam.portal.entity.Users;
import com.exam.portal.globalException.UserFoundException;
import com.exam.portal.service.UserService;


@SpringBootApplication
public class ExpertExamApplication {
	
//	@Autowired
//	private UserService userService;
//	
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args){
		SpringApplication.run(ExpertExamApplication.class, args);
		
//		n.create();
	}

  
//  public void create() throws Exception {
//      try {
//
//
//          System.out.println("starting code");
////
//          Users user = new Users();
//
//          user.setFirstName("Durgesh");
//          user.setLastName("Tiwari");
//          user.setUserName("durgesh8896");
//          user.setPassword(bCryptPasswordEncoder.encode("abc"));
//          user.setEmail("abc@gmail.com");
//          user.setProfile("default.png");
//
//          Role role1 = new Role();
//          role1.setRoleId(44);
//          role1.setRole("ADMIN");
//
//          Set<UserRole> userRoleSet=new HashSet<>();
//          UserRole userRole = new UserRole();
//
//          userRole.setRole(role1);
//
//          userRole.setUsers(user);
//
//          userRoleSet.add(userRole);
//
//          Users user1 = this.userService.createUser(user, userRoleSet);
//          System.out.println(user1.getUserName());
//
//
//      } catch (UserFoundException e) {
//          e.printStackTrace();
//
//
//      }
//
//
//  }
	
}
