package org.cbi.hit.ts_core.exceptions;

import org.cbi.hit.ts_core.rest.exception_mapper.ErrorResponse;

@SuppressWarnings("serial")
public class BusinessException extends Exception {
	private ErrorResponse error;
	
	public BusinessException(ErrorResponse error)
	{
		super(error.getErrorEnum().getMessage());
		this.error = error;
	}

	public ErrorResponse getError() {
		return error;
	}
	
	
}
