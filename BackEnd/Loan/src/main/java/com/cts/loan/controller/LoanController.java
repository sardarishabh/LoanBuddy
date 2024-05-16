package com.cts.loan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.loan.feign.AuthorisationClient;
import com.cts.loan.model.Loan;
import com.cts.loan.service.LoanService;

@RestController
@CrossOrigin(origins = "*")
public class LoanController {

	@Autowired
	LoanService loanService;

	@Autowired
	AuthorisationClient authorisationClient;

	@GetMapping("/health-check")
	public ResponseEntity<String> healthCheck() {
		return new ResponseEntity<>("Loan Ok", HttpStatus.OK);
	}
	
	
	/* Rishabh -----> View Loan Products */
	@GetMapping("/loans")
	public ResponseEntity<List<Loan>> viewAllLoans(@RequestHeader(name = "Authorization") String token) {
		ResponseEntity<List<Loan>> entity = null;
		if (authorisationClient.validate(token)) {
			entity = new ResponseEntity<>(loanService.viewAllLoans(), HttpStatus.OK);
		} else {
			entity = new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		return entity;
	}

	@GetMapping("/loan/{id}")
	public ResponseEntity<Loan> loanById(@RequestHeader(name = "Authorization") String token, @PathVariable int id) {
		ResponseEntity<Loan> entity = null;
		if (authorisationClient.validate(token)) {
			entity = new ResponseEntity<>(loanService.loanById(id), HttpStatus.OK);
		} else {
			entity = new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		return entity;
	}
	
	

	/* Rishabh -----> Add and Update Loan Products */
	@PutMapping("/loan/{id}")
	public ResponseEntity<String> updateLoan(@RequestHeader(name = "Authorization") String token, @PathVariable int id,
			@RequestBody Loan loan) {
		ResponseEntity<String> entity = null;
		if (authorisationClient.validate(token)) {
			String loanType = loanService.loanById(id).getLoanName();
			loanService.updateLoan(id, loan);
			entity = new ResponseEntity<String>("Loan Type : '"+loanType+"' updated.", HttpStatus.OK);
		} else {
			entity = new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		return entity;
	}

	@PostMapping("/loan")
	public ResponseEntity<String> addLoan(@RequestHeader(name = "Authorization") String token, @RequestBody Loan loan) {
		
		ResponseEntity<String> entity = null;
		if (authorisationClient.validate(token)) {
			loanService.addLoan(loan);
			entity = new ResponseEntity<String>("New Loan Type Added", HttpStatus.CREATED);
		} else {
			entity = new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		return entity;
	}

	@DeleteMapping("/loan/{id}")
	public ResponseEntity<String> deleteLoan(@RequestHeader(name = "Authorization") String token, @PathVariable int id) {
		ResponseEntity<String> entity = null;
		if (authorisationClient.validate(token)) {
			String loanType = loanService.loanById(id).getLoanName();
			loanService.deleteLoanById(id);
			entity = new ResponseEntity<String>("Loan Type : '"+loanType+"' deleted.", HttpStatus.OK);
		} else {
			entity = new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		return entity;
	}

}