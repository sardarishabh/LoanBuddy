package com.cts.authorization.model;

import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Model class for fetching user credentials while login
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserCredentials {

	private String userName;

	@Pattern(regexp = "(?=.*\\d)(?=.*[a-zA-Z]).{4,}", message = "Password should contain alpha numeric values")
	private String password;
}
