package org.cbi.hit.ts_core.rest.exception_mapper;

import javax.ws.rs.core.Response.Status;

public class ErrorResponse {
	private Status errorStatus; //internal server error or client error or ...
	private ErrorEnum errorEnum;
	private String errorDetails;
	
	
	public ErrorResponse(Status errorStatus, ErrorEnum errorEnum, String errorDetails) {
		super();
		this.errorStatus = errorStatus;
		this.errorEnum = errorEnum;
		this.errorDetails = errorDetails;
	}
	
	public ErrorEnum getErrorEnum() {
		return errorEnum;
	}
	public void setErrorEnum(ErrorEnum errorEnum) {
		this.errorEnum = errorEnum;
	}
	public Status getErrorStatus() {
		return errorStatus;
	}
	public void setErrorStatus(Status errorStatus) {
		this.errorStatus = errorStatus;
	}
	public String getErrorDetails() {
		return errorDetails;
	}
	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}
	public int getErrorCode() {
		return errorEnum.getCode();
	}
	public String getErrorMessage() {
		return errorEnum.getMessage();
	}
	
	
}
