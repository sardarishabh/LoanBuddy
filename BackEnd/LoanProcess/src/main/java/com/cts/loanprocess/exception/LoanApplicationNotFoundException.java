package com.cts.loanprocess.exception;

/**
 * Class for handling UserNotFoundException
 */
public class LoanApplicationNotFoundException extends RuntimeException {

	public LoanApplicationNotFoundException(String msg) {
		super(msg);
	}

	/**
	 * This method sets the custom error message
	 * 
	 * @param message
	 */
	private static final long serialVersionUID = 1L;

}
