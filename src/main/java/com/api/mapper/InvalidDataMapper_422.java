package com.api.mapper;

import com.api.exception.InvalidDataException;

import javax.ws.rs.core.*;
import javax.ws.rs.ext.*;

@Provider
public class InvalidDataMapper_422 implements ExceptionMapper<InvalidDataException> {
    @Override
    public Response toResponse(InvalidDataException ex) {
        return Response.status(422)
                .entity(ex.getMessage())
                .build();
    }
}
