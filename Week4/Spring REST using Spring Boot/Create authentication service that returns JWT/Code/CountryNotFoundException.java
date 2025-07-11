package com.cognizant.spring_learn.exception;

public class CountryNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CountryNotFoundException(String code) {
        super("Country with code '" + code + "' not found.");
    }

	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}
}
