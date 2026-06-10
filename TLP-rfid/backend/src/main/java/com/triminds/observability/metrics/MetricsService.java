package com.triminds.observability.metrics;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class MetricsService {

    private final AtomicLong rfidEvents = new AtomicLong();

    public void incrementRfidEvents() {
        rfidEvents.incrementAndGet();
    }

    public long getRfidEvents() {
        return rfidEvents.get();
    }
}