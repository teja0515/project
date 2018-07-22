package com.java.string.Accumulator;
/**
 * This is customized exception class to handle negative numbers
 * 
 * @author Teja
 *
 */
public class NegativeNumberException extends Exception{
	
	public NegativeNumberException(Exception excObj, String message){
		super();
		this.excObj = excObj;
		this.message = message;
	}
	
	private Exception excObj;
	private String message;
	
	/**
	 * This method fetches the exception object.
	 * 
	 * @return the exception object of string type
	 */
	public Exception getExcObj() {
		return excObj;
	}
	
	/**
	 * This method sets the value for the exception message
	 * 
	 * @param excObj 
	 * 				the new exception object
	 */
	public void setExcObj(Exception excObj) {
		this.excObj = excObj;
	}
	
	/**
	 * This method fetches the exception message.
	 * 
	 * @return the exception message of string type
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * This method sets the value for the exception message
	 * 
	 * @param message
	 * 				the new exception message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
