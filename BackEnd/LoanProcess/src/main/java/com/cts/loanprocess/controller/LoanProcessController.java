package com.cts.loanprocess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.loanprocess.feign.AuthorisationClient;
import com.cts.loanprocess.model.LoanApplication;
import com.cts.loanprocess.service.LoanProcessService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(origins = "*")
public class LoanProcessController {

	@Autowired
	AuthorisationClient authClient;
	
	@Autowired
	LoanProcessService loanProcessService;

	@Autowired
	AuthorisationClient authorisationClient;

	@GetMapping("/health-check")
	public ResponseEntity<String> healthCheck() {
		return new ResponseEntity<>("LoanProcess Ok", HttpStatus.OK);
	}

	
	//Aryan---apply for loan
	@PostMapping("/application")
	public ResponseEntity<String> applyLoanApplication(@RequestHeader(name = "Authorization") String token,
			@RequestBody LoanApplication loanApplication) {

		ResponseEntity<String> entity = null;
		if (authorisationClient.validate(token)) {
			loanProcessService.addLoanApplication(loanApplication);
			entity = new ResponseEntity<String>("Loan Application Submitted", HttpStatus.CREATED);
		} else {
			entity = new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		return entity;
	}
	
	//Lokesh -- Update Loan Status
	@PutMapping("/loanApplication")
	public ResponseEntity<String> updateStatus(@RequestHeader(name = "Authorization") String token, @RequestBody LoanApplication loanObj) {
		ResponseEntity<String> entity= null;
		log.info("updating loan status");
		if (authClient.validate(token)) {
			loanProcessService.updateStatus(loanObj.getApplicationId(), loanObj.getLoanStatus());
			entity = new ResponseEntity<>("Status Successfully Updated", HttpStatus.OK);
		} else {
			entity = new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		log.info("status updated");
		return entity;
	}
		
	//Lokesh -- View Loan Applications
	@GetMapping("/loanApplications")
	public ResponseEntity<List<LoanApplication>> viewAllLoanApplications(@RequestHeader(name = "Authorization") String token) {
		ResponseEntity<List<LoanApplication>> entity=null;
		log.info("Fetching All Loan Applications");
		if (authClient.validate(token)) {
			entity = new ResponseEntity<>(loanProcessService.viewAllLoanApplications(), HttpStatus.OK);
		} else {
			entity =  new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		log.info("Applications fetched");
		return entity;
	}
		
	//Lokesh -- View Loan Application By ID
	@GetMapping("/loanApplication/{id}")
	public ResponseEntity<LoanApplication> viewLoanApplication(@RequestHeader(name = "Authorization") String token, @PathVariable int id) {
		ResponseEntity<LoanApplication> entity=null;
		log.info("Fetching Loan Application");
		if (authClient.validate(token)) {
			entity = new ResponseEntity<>(loanProcessService.viewLoanApplication(id), HttpStatus.OK);
		} else {
			entity =  new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		log.info("Application Fetched");
		return entity;
	}

}
