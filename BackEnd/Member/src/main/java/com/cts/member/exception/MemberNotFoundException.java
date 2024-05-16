package com.cts.member.exception;

/**
 * Class for handling UserNotFoundException
 */
public class MemberNotFoundException extends RuntimeException {

	public MemberNotFoundException(String msg) {
		super(msg);
	}

	/**
	 * This method sets the custom error message
	 * 
	 * @param message
	 */
	private static final long serialVersionUID = 1L;

}
