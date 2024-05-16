package com.cts.loan.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;

class LoanTest {
	
	Loan loan = null;

	@BeforeEach
	void setUp() throws Exception {
		loan = new Loan();
	}

	@Test
	void loanIdtest() {
		assertThat(loan,hasProperty("loanId"));
	}
	
	@Test
	void loanNametest() {
		assertThat(loan,hasProperty("loanName"));
	}
	
	@Test
	void descriptiontest() {
		assertThat(loan,hasProperty("description"));
	}

}
