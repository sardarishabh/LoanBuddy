package com.cts.member.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;

class MemberTest {
	
	Member member = null;

	@BeforeEach
	void setUp() throws Exception {
		member = new Member();
	}
	
	@Test
	void memberIdTest() {
		assertThat(member,hasProperty("memberId"));
	}

	@Test
	void firstNameTest() {
		assertThat(member,hasProperty("firstName"));
	}
	
	@Test
	void lastNameTest() {
		assertThat(member,hasProperty("lastName"));
	}
	
	@Test
	void addressTest() {
		assertThat(member,hasProperty("address"));
	}
	
	@Test
	void contactNumberTest() {
		assertThat(member,hasProperty("contactNumber"));
	}
	
	@Test
	void emailIdTest() {
		assertThat(member,hasProperty("emailId"));
	}
	
	@Test
	void genderTest() {
		assertThat(member,hasProperty("gender"));
	}
	
	@Test
	void civilStatusTest() {
		assertThat(member,hasProperty("civilStatus"));
	}
	
	@Test
	void dateOfBirthTest() {
		assertThat(member,hasProperty("dateOfBirth"));
	}
	
	@Test
	void ageTest() {
		assertThat(member,hasProperty("age"));
	}
	
	@Test
	void userNameTest() {
		assertThat(member,hasProperty("userName"));
	}
	
	@Test
	void password() {
		assertThat(member,hasProperty("password"));
	}
	
	@Test
	void memberTypeTest() {
		assertThat(member,hasProperty("memberType"));
	}

}
