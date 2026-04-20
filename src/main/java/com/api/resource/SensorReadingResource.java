package com.api.resource;

import com.api.DataStore;
import com.api.model.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.*;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SensorReadingResource {

    private int sensorId;

    public SensorReadingResource(int sensorId) {
        this.sensorId = sensorId;
    }

    @GET
    public List<SensorReading> getReadings() {
        return DataStore.readings.getOrDefault(sensorId, new ArrayList<>());
    }

    @POST
    public Response addReading(SensorReading reading) {

        Sensor sensor = DataStore.sensors.get(sensorId);

        if (sensor == null) {
            return Response.status(404).entity("Sensor not found").build();
        }

        if ("MAINTENANCE".equals(sensor.getStatus())) {
            return Response.status(403).entity("Sensor unavailable").build();
        }

        DataStore.readings
                .computeIfAbsent(sensorId, k -> new ArrayList<>())
                .add(reading);

        sensor.setCurrentValue(reading.getValue());

        return Response.status(201).entity(reading).build();
    }
}