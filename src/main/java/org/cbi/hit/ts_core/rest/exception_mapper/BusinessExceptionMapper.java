package org.cbi.hit.ts_core.rest.exception_mapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.cbi.hit.ts_core.exceptions.BusinessException;

@Provider
public class BusinessExceptionMapper implements ExceptionMapper<BusinessException>{
	@Override
	public Response toResponse(BusinessException exception) {
		return Response.status(exception.getError().getErrorStatus())
				.entity(exception.getError()).type(MediaType.APPLICATION_JSON).build();
	}
}
