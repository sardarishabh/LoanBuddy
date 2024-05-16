package com.cts.authorization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.authorization.model.MyUser;
import com.cts.authorization.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo userRepo;
	
	public void insertUser(MyUser user) {
		userRepo.save(user);
	}

}
