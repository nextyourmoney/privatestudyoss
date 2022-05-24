package com.mycompany.myapp.exception;

public class Ch16NotFoundAccountException extends RuntimeException {
	public Ch16NotFoundAccountException() {
	}
	
	public Ch16NotFoundAccountException(String message) {
		super(message);
	}
}
