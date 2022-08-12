package com.example.basketballmanagment.exception;

public class MaximumPlayerException extends RuntimeException  {

	 public MaximumPlayerException(String message) {
	        super(message + "Maximum number is 12");
	    }
}
