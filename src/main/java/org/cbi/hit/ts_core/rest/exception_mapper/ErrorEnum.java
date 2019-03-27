package org.cbi.hit.ts_core.rest.exception_mapper;

public enum ErrorEnum {
	NOT_FOUND(101, "The requested resource was not found"),
	INTERNAL_ERROR(103, "An internal error occured in server")
	;
	
	private int code;
	private String message;
	
	private ErrorEnum(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
	
	
	
}
