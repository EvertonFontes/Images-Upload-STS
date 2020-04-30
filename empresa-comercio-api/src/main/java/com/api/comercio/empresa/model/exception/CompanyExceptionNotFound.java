package com.api.comercio.empresa.model.exception;

public class CompanyExceptionNotFound extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public CompanyExceptionNotFound(String message) {
        super(message);
    }

    public CompanyExceptionNotFound(String message, Throwable cause) {
        super(message, cause);
    }  

}
