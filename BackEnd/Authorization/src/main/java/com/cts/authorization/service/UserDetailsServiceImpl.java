package com.cts.authorization.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.cts.authorization.model.MyUser;
import com.cts.authorization.repository.UserRepo;

import lombok.extern.slf4j.Slf4j;

/**
 * Service implementation class for UserDetailsService
 */
@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	/**
	 * Overriding method to load the user details from database with user name
	 * 
	 * @param userName
	 * @return This returns the user name and password
	 */
	@Override
	public UserDetails loadUserByUsername(String username) {
		MyUser user = userRepo.findByUserName(username);
		return new User(user.getUserName(), user.getPassword(), new ArrayList<>());
	}
	
}
