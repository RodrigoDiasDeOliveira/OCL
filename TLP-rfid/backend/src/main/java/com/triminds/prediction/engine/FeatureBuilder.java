package com.triminds.prediction.engine;

import com.triminds.rfid.model.RfidEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FeatureBuilder {

    public double[] build(List<RfidEvent> events) {

        if (events == null || events.isEmpty()) {
            return new double[]{0, 0};
        }

        RfidEvent last = events.get(events.size() - 1);

        double locationCode = encode(last.getLocation());
        double velocity = events.size(); // simples baseline

        return new double[]{locationCode, velocity};
    }

    private double encode(String location) {
        if (location == null) return 0;

        return switch (location.toLowerCase()) {
            case "warehouse-a" -> 1;
            case "warehouse-b" -> 2;
            case "shipping-zone" -> 3;
            default -> 0;
        };
    }
}