package com.exam.portal.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.exam.portal.config.JwtUtils;
import com.exam.portal.entity.Users;
import com.exam.portal.globalException.UserNotFoundException;
import com.exam.portal.modal.LoginRequest;
import com.exam.portal.modal.ResponsToken;
import com.exam.portal.serviceImplementation.UserDetailsImplementaion;
import com.exam.portal.serviceImplementation.UsersDetails;
@RequestMapping("/auth")
@RestController
public class AuthenticationController {

	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsImplementaion userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;
    
    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody LoginRequest jwtRequest) throws Exception {

    	System.out.println("------------------sonmthing wrong"+jwtRequest.getPassword()+jwtRequest.getUserName());
    	
        try {

            authenticate(jwtRequest.getUserName(), jwtRequest.getPassword());


        } catch (UserNotFoundException e) {
            e.printStackTrace();
            throw new Exception("User not found ");
        }

        /////////////authenticate

        UserDetails userDetails = (UsersDetails) userDetailsService.loadUserByUsername(jwtRequest.getUserName());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new ResponsToken(token));


    }


    private void authenticate(String username, String password) throws Exception {

        try {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        } catch (DisabledException e) {
            throw new Exception("USER DISABLED " + e.getMessage());
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid Credentials " + e.getMessage());
        }
    }
    
    @GetMapping("/current-user")
    public UserDetails getCurrentUser(Principal principal) {
        return this.userDetailsService.loadUserByUsername(principal.getName());

    }
    
	
}
