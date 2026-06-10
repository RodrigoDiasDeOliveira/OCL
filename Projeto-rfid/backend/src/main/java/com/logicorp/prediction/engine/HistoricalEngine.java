package com.logicorp.prediction.engine;

import com.logicorp.rfid.model.RfidEvent;
import com.logicorp.rfid.model.RfidTag;
import com.logicorp.rfid.service.RfidEventService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HistoricalEngine {

    private final RfidEventService eventService;

    public HistoricalEngine(RfidEventService eventService) {
        this.eventService = eventService;
    }

    public PredictionResult predict(RfidTag tag) {

        List<RfidEvent> history = eventService.getHistory(tag.getTagId());

        if (history.isEmpty()) {
            return new PredictionResult(
                    tag.getTagId(),
                    fallback(tag),
                    "HISTORICAL",
                    0.4
            );
        }

        // 🧠 lógica simples evolutiva (base real)
        String lastLocation = history.get(history.size() - 1).getLocation();

        String predicted = switch (lastLocation.toLowerCase()) {
            case "warehouse-a" -> "warehouse-b";
            case "warehouse-b" -> "shipping-zone";
            case "shipping-zone" -> "in-transit";
            default -> "analysis-required";
        };

        return new PredictionResult(
                tag.getTagId(),
                predicted,
                "HISTORICAL",
                0.75
        );
    }

    private String fallback(RfidTag tag) {
        return tag.getLocation() != null ? tag.getLocation() : "unknown";
    }
}