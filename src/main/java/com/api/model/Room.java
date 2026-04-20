package com.api.model;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private int id;
    private String name;
    private int capacity;
    private List<String> sensorIds = new ArrayList<>();

    public Room(int i, String conferenceRoom) {}


    public Room() {}


    public Room(int id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public List<String> getSensorIds() { return sensorIds; }
    public void setSensorIds(List<String> sensorIds) { this.sensorIds = sensorIds; }
}