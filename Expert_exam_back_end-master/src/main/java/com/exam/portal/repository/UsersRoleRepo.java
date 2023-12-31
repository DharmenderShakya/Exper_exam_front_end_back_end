package com.exam.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.portal.entity.UserRole;

@Repository
public interface UsersRoleRepo extends JpaRepository<UserRole, Integer>{

}
