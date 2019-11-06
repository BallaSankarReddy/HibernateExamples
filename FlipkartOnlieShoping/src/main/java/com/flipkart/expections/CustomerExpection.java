package com.flipkart.expections;

import java.io.IOException;

public class CustomerExpection extends IOException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerExpection(String message) { 
		message="Customer data not looking good , pls check and try again.., thanks!";
		
	}
	
	
}
