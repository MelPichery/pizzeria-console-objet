package com.pizzeria.exception;

public class UpDatePizzaException extends StockageException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UpDatePizzaException() {
		
	}
	
	public UpDatePizzaException(String message) {
		super(message);
	}

}
