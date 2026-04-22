package com.api.mapper;
import com.api.exception.ResourceNotFoundException;

import javax.ws.rs.core.*;
import javax.ws.rs.ext.*;

@Provider
public class NotFoundMapper implements ExceptionMapper<ResourceNotFoundException> {
    @Override
    public Response toResponse(ResourceNotFoundException ex) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(ex.getMessage())
                .build();
    }
}
