package com.example.demo;

public class TimestampResponse {
    private final long timestamp;

    public TimestampResponse(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
