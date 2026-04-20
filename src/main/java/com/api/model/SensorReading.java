package com.api.model;

public class SensorReading {

    private int id;
    private long timestamp;
    private double value;

    public SensorReading() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }

    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }
}