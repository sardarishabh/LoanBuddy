package com.cts.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cts.member.feign.AuthorisationClient;
import com.cts.member.model.Member;
import com.cts.member.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(origins = "*")
public class MemberController {
	// Shagun
	@Autowired
	MemberService memberService;

	@Autowired
	private AuthorisationClient authClient;

	@GetMapping("/health-check")
	public ResponseEntity<String> healthCheck() {
		return new ResponseEntity<>("Member Ok", HttpStatus.OK);
	}

	@PostMapping("/member")
	public ResponseEntity<String> registerUser(@RequestBody Member member) {
		log.info(member.getUserName() + " : " + member.getPassword());
		authClient.addUser(member.getUserName(), member.getPassword());

		memberService.registerMember(member);
		return new ResponseEntity<String>("Inserted", HttpStatus.CREATED);
	}

	@GetMapping("/members")
	public ResponseEntity<List<Member>> getAllMembersForAdmin(@RequestHeader(name = "Authorization") String token) {
		ResponseEntity<List<Member>> entity = null;
		if (authClient.validate(token)) {
			entity = new ResponseEntity<>(memberService.getAllMembersForAdmin(), HttpStatus.OK);
		} else {
			entity = new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		return entity;
	}

	// Rishabh
	@GetMapping("/member/{id}")
	public ResponseEntity<Member> viewMemberById(@RequestHeader(name = "Authorization") String token,
			@PathVariable int id) {
		ResponseEntity<Member> entity = null;
		if (authClient.validate(token)) {
			entity = new ResponseEntity<>(memberService.memberById(id), HttpStatus.OK);
		} else {
			entity = new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		return entity;
	}

	@GetMapping("/memberType/{id}")
	public ResponseEntity<String> viewMemberType(@RequestHeader(name = "Authorization") String token,
			@PathVariable int id) {
		ResponseEntity<String> entity = null;
		if (authClient.validate(token)) {
			entity = new ResponseEntity<>(memberService.memberType(id), HttpStatus.OK);
		} else {
			entity = new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		return entity;
	}

	@GetMapping("/memberName/{userName}")
	public ResponseEntity<Member> viewMemberByUserName(@RequestHeader(name = "Authorization") String token,
			@PathVariable String userName) {
		ResponseEntity<Member> entity = null;
		if (authClient.validate(token)) {
			entity = new ResponseEntity<>(memberService.memberByUserName(userName), HttpStatus.OK);
		} else {
			entity = new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		return entity;
	}

}
