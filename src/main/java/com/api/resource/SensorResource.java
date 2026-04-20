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
    public Collection<Sensor> getSensors() {
        return DataStore.sensors.values();
    }

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
}