package com.logicorp.analytics.service;

import com.logicorp.rfid.model.RfidEvent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThroughputCalculator {

    public double calculateHourlyThroughput(List<RfidEvent> events) {

        if (events == null || events.isEmpty()) {
            return 0;
        }

        return events.size() / 24.0;
    }
}