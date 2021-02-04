package com.bytesculptor.batterytempcore.model;

public class ValuePairEntity {

    long timestamp;
    int value;

    public ValuePairEntity(long timestamp, int value) {
        this.timestamp = timestamp;
        this.value = value;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
