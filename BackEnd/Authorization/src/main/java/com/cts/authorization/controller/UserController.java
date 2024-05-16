package com.cts.authorization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.authorization.model.MyUser;
import com.cts.authorization.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
	//Shagun
	@Autowired
	UserService userService;
	
	@PostMapping("/user/{userName}/{password}")
	public ResponseEntity<String> addUser(@PathVariable String userName, @PathVariable String password) {
		MyUser user = new MyUser();
		user.setUserName(userName);
		user.setPassword(password);
		userService.insertUser(user);
		return new ResponseEntity("Inserted ", HttpStatus.CREATED);
	}

}
