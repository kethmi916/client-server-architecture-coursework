package com.api.mapper;

import javax.ws.rs.core.*;
import javax.ws.rs.ext.*;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper_500 implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception ex) {
        ex.printStackTrace();

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Internal server error")
                .build();
    }
}
