package com.cts.loanprocess.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;

class LoanApplicationTest {
	
	LoanApplication loanApplication = null;

	@BeforeEach
	void setUp() throws Exception {
		
		loanApplication = new LoanApplication();
	}

	@Test
	void applicationIdtest() {
		assertThat(loanApplication,hasProperty("applicationId"));
	}
	
	@Test
	void memberIdtest() {
		assertThat(loanApplication,hasProperty("memberId"));
	}
	
	@Test
	void loanIdtest() {
		assertThat(loanApplication,hasProperty("loanId"));
	}
	
	@Test
	void modeOfPaymenttest() {
		assertThat(loanApplication,hasProperty("modeOfPayment"));
	}
	
	@Test
	void loanAmounttest() {
		assertThat(loanApplication,hasProperty("loanAmount"));
	}
	
	@Test
	void loanDurationtest() {
		assertThat(loanApplication,hasProperty("loanDuration"));
	}
	
	@Test
	void purposetest() {
		assertThat(loanApplication,hasProperty("purpose"));
	}
	
	@Test
	void loanStatustest() {
		assertThat(loanApplication,hasProperty("loanStatus"));
	}

}
