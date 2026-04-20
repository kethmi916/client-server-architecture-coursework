package com.api.resource;

import com.api.DataStore;
import com.api.model.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.*;
@Path("/sensors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SensorResource {


    @GET
    @Path("/{id}")
    public Response getSensor(@PathParam("id") int id) {
        Sensor sensor = DataStore.sensors.get(id);

        if (sensor == null) {
            return Response.status(404).entity("Sensor not found").build();
        }

        return Response.ok(sensor).build();
    }
    @Path("/{id}/readings")
    public SensorReadingResource getReadingsResource(@PathParam("id") int id) {
        return new SensorReadingResource(id);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteSensor(@PathParam("id") int id) {
        Sensor removed = DataStore.sensors.remove(id);

        if (removed == null) {
            return Response.status(404).entity("Sensor not found").build();
        }

        return Response.noContent().build();
    }
    @GET
    public  Collection<Sensor> getSensors(@QueryParam("type") String type){
        if (type == null) {
            return DataStore.sensors.values();
        }

        List<Sensor> filtered = new ArrayList<>();

        for (Sensor s : DataStore.sensors.values()) {
            if (type.equalsIgnoreCase(s.getType())) {
                filtered.add(s);
            }
        }

        return filtered;
    }
    @POST
    public Response createSensor(Sensor sensor) {

        if (!DataStore.rooms.containsKey(sensor.getRoomId())) {
            return Response.status(422).entity("Invalid room ID").build();
        }

        DataStore.sensors.put(sensor.getId(), sensor);

        return Response.status(201).entity(sensor).build();
    }
    @PUT
    @Path("/{id}")
    public Response updateSensor(@PathParam("id") int id, Sensor updatedSensor) {

        Sensor existing = DataStore.sensors.get(id);

        if (existing == null) {
            return Response.status(404).entity("Sensor not found").build();
        }

        existing.setType(updatedSensor.getType());
        existing.setStatus(updatedSensor.getStatus());
        existing.setRoomId(updatedSensor.getRoomId());

        return Response.ok(existing).build();
    }
}