package com.exam.portal.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.portal.entity.Role;
import com.exam.portal.entity.UserRole;
import com.exam.portal.entity.Users;
import com.exam.portal.globalException.UserFoundException;

import com.exam.portal.service.UserService;
@RequestMapping("/user")
@RestController
public class Usercontroller {
	
	 @Autowired
	    private UserService userService;

	 @Autowired
	    private BCryptPasswordEncoder bCryptPasswordEncoder;
	 
	    //creating user
	    @PostMapping("/")
	    public Users createUser(@RequestBody Users user) throws Exception {

	        user.setProfile("default.png");
	        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
	        Set<UserRole> roles = new HashSet<>();

	        Role role = new Role();
	        role.setRole("NORMAL");
	        UserRole userRole = new UserRole();
	        userRole.setUsers(user);
	        userRole.setRole(role);
	        roles.add(userRole);
	        Users users=userService.createUser(user, roles);
	        return users; 
	    }

	    @GetMapping("/{username}")
	    public Users getUser(@PathVariable("username") String username) {
	        return this.userService.getUser(username);
	    }

	    //delete the user by id
	    @DeleteMapping("/{userId}")
	    public void deleteUser(@PathVariable("userId") int userId) {
	        this.userService.deleteUser(userId);
	    }



	    @ExceptionHandler(UserFoundException.class)
	    public ResponseEntity<?> exceptionHandler(UserFoundException ex) {
	        return ResponseEntity.ok(ex.getMessage());
	    }
	
}
