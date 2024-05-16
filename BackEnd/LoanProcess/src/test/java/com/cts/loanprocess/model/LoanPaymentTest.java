package com.cts.loanprocess.model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoanPaymentTest {
	
	LoanPayment loanPayment = null;

	@BeforeEach
	void setUp() throws Exception {
		loanPayment = new LoanPayment();
	}
	
	@Test
	void paymentIdtest() {
		assertThat(loanPayment,hasProperty("paymentId"));
	}

	@Test
	void applicationIdtest() {
		assertThat(loanPayment,hasProperty("applicationId"));
	}
	
	@Test
	void dateOfPaymenttest() {
		assertThat(loanPayment,hasProperty("dateOfPayment"));
	}
	
	@Test
	void amounttest() {
		assertThat(loanPayment,hasProperty("amount"));
	}
	
	@Test
	void interestPaidtest() {
		assertThat(loanPayment,hasProperty("interestPaid"));
	}
	
	@Test
	void principalPaidtest() {
		assertThat(loanPayment,hasProperty("principalPaid"));
	}
	
	@Test
	void balancetest() {
		assertThat(loanPayment,hasProperty("balance"));
	}

}
