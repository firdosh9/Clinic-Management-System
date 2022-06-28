package net.javaproject.cms.service;

import java.util.List;

import net.javaproject.cms.entity.Users;

public interface UserService {
	List<Users> getAllUsers();
	
	Users getUserById(Long id);
	
	Users verifyLogin(String email, String password );
}
