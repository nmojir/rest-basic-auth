package org.cbi.hit.ts_core.exceptions;

import javax.ws.rs.core.Response.Status;

import org.cbi.hit.ts_core.rest.exception_mapper.ErrorEnum;
import org.cbi.hit.ts_core.rest.exception_mapper.ErrorResponse;

@SuppressWarnings("serial")
public class InternalErrorException extends BusinessException {

	public InternalErrorException(String detail) {
		super(new ErrorResponse(
				Status.INTERNAL_SERVER_ERROR, 
				ErrorEnum.INTERNAL_ERROR, 
				detail
			)
		);
	}

}
