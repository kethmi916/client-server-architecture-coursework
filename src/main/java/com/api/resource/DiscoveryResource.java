package com.api.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class DiscoveryResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfo() {
        return "{\n" +
                "  \"contact\": \"admin@uni.com\",\n" +
                "  \"resources\": {\n" +
                "    \"rooms\": \"/api/v1/rooms\",\n" +
                "    \"sensors\": \"/api/v1/sensors\"\n" +
                "  },\n" +
                "  \"version\": \"1.0\"\n" +
                "}";
    }
}