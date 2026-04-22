package com.api.mapper;
import com.api.exception.RoomNotEmptyException;

import javax.ws.rs.core.*;
import javax.ws.rs.ext.*;

@Provider
public class RoomNotEmptyMapper409 implements ExceptionMapper<RoomNotEmptyException> {
    @Override
    public Response toResponse(RoomNotEmptyException ex) {
        return Response.status(Response.Status.CONFLICT)
                .entity(ex.getMessage())
                .build();
    }
}
