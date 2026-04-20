package com.api;

import com.api.model.*;
import java.util.*;

public class DataStore {

    public static Map<Integer, Room> rooms = new HashMap<>();
    public static Map<Integer, Sensor> sensors = new HashMap<>();
    public static Map<Integer, List<SensorReading>> readings = new HashMap<>();

    static {
        rooms.put(1, new Room(1, "Conference Room"));
        rooms.put(2, new Room(2, "Lecture Hall"));

        Sensor s1 = new Sensor();
        s1.setId(1);
        s1.setType("Temperature");
        s1.setStatus("ACTIVE");
        s1.setRoomId(1);

        Sensor s2 = new Sensor();
        s2.setId(2);
        s2.setType("Humidity");
        s2.setStatus("ACTIVE");
        s2.setRoomId(2);

        sensors.put(1, s1);
        sensors.put(2, s2);
    }


}