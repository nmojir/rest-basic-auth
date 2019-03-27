package org.cbi.hit.ts_core.exceptions;

import javax.ws.rs.core.Response.Status;

import org.cbi.hit.ts_core.rest.exception_mapper.ErrorEnum;
import org.cbi.hit.ts_core.rest.exception_mapper.ErrorResponse;

@SuppressWarnings("serial")
public class NotFoundException extends BusinessException{

	public NotFoundException(String detail) {
		super(new ErrorResponse(
				Status.NOT_FOUND, 
				ErrorEnum.NOT_FOUND, 
				detail
			)
		);
	}

}
