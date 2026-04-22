package com.api.resource;

import com.api.DataStore;
import com.api.exception.ResourceNotFoundException;
import com.api.exception.RoomNotEmptyException;
import com.api.model.Room;
import com.api.model.Sensor;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.*;

@Path("/rooms")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RoomResource {

    @GET
    public Collection<Room> getRooms() {
        return DataStore.rooms.values();
    }

    @POST
    public Response createRoom(Room room) {
        DataStore.rooms.put(room.getId(), room);
        return Response.status(Response.Status.CREATED).entity(room).build();
    }

    @GET
    @Path("/{id}")
    public Response getRoom(@PathParam("id") int id) {
        Room room = DataStore.rooms.get(id);

        if (room == null) {
            return Response.status(404).build();
        }

        return Response.ok(room).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteRoom(@PathParam("id") int id) {

        Room room = DataStore.rooms.get(id);

        if (room == null) {
            return Response.status(404).build();
        }


        for (Sensor s : DataStore.sensors.values()) {
            if (s.getRoomId() == id) {
                throw new RoomNotEmptyException("Room has sensors");
            }
        }

        DataStore.rooms.remove(id);
        return Response.noContent().build();
    }
    @PUT
    @Path("/{id}")
    public Response updateRoom(@PathParam("id") int id, Room updatedRoom) {

        Room existing = DataStore.rooms.get(id);

        if (existing == null) {
            throw new ResourceNotFoundException("Room not found");        }

        existing.setName(updatedRoom.getName());
        existing.setCapacity(updatedRoom.getCapacity());

        return Response.ok(existing).build();
    }
}