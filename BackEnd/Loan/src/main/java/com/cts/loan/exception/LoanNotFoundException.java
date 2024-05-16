package com.cts.loan.exception;

/**
 * Class for handling UserNotFoundException
 */
public class LoanNotFoundException extends RuntimeException {

	public LoanNotFoundException(String msg) {
		super(msg);
	}

	/**
	 * This method sets the custom error message
	 * 
	 * @param message
	 */
	private static final long serialVersionUID = 1L;

}
