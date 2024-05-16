package com.cts.loan.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cts.loan.controller.LoanController;
import com.cts.loan.exception.LoanNotFoundException;
import com.cts.loan.model.Loan;
import com.cts.loan.service.LoanService;

@ExtendWith(MockitoExtension.class)
class LoanControllerTest {
	
	@InjectMocks
	LoanController loanController;
	
	@Mock
	LoanService loanService;
	
	@Before
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test(expected = LoanNotFoundException.class)
	public void loanIdNotFoundTest() {
		Loan loan = new Loan(120, "Books Loan", "Provided by Bank of Pod3");
		loanController.loanById(null, 130);
		
	}
	
	@Test
	public void testHealthCheck(){
		assertEquals(200,loanController.healthCheck().getStatusCodeValue());
	}
	
	@Test
	public void addLoanTest() {
		MockHttpServletRequest req = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(req));
		
		//when(loanService.addLoan(any(Loan.class))).thenReturn(true);
		
		Loan loan1 = new Loan(115, "Party Loan", "Provided by Reserve Bank of POD3");
		
		ResponseEntity<String> responseEntity = loanController.addLoan(null, loan1);
		
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
		assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("");
		
	}
	
	@Test
	public void viewAllLoansTest() {
		List<Loan> list = new ArrayList<Loan>();
		Loan loan1 = new Loan(115, "Party Loan", "Provided by Reserve Bank of POD3");
		Loan loan2 = new Loan(120, "Books Loan", "Provided by Reserve Bank of POD3");
		
		list.add(loan1);
		list.add(loan2);
		
		when(loanService.viewAllLoans()).thenReturn(list);
		
		ResponseEntity<List<Loan>> loanList = loanController.viewAllLoans(null);
		
		assertThat(loanList.getStatusCodeValue()).isEqualTo(201);
	}

	

}
