package com.exam.portal.serviceImplementation;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.exam.portal.entity.UserRole;
import com.exam.portal.entity.Users;
import com.exam.portal.globalException.UserFoundException;
import com.exam.portal.repository.RolesRepo;
import com.exam.portal.repository.UsersRepo;
import com.exam.portal.service.UserService;

@Service
public class UserServiceImplementation implements UserService{

	@Autowired
	UsersRepo usersRepo;
	
	@Autowired
	RolesRepo rolesRepo;
	
	@Override
	public Users createUser(Users user, Set<UserRole> userRole)throws Exception {
		Users local = this.usersRepo.findByUserName(user.getUserName());
        if (local != null) {
            System.out.println("User is already there !!");
            throw new UserFoundException();
        } else {
            //user createz
            for (UserRole ur : userRole) {
            	rolesRepo.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRole);
            System.out.println("------------------------------------error generating form here");
            local = this.usersRepo.save(user);
        }
        
        return local;
	}

	@Override
	public Users getUser(String userName) {
		// TODO Auto-generated method stub
		return usersRepo.findByUserName(userName);
	}

	@Override
	public void deleteUser(int userId) {
		usersRepo.deleteById(userId);
	}	
	
}
