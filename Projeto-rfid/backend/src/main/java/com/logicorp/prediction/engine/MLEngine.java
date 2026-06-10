package com.logicorp.prediction.engine;

import com.logicorp.rfid.model.RfidTag;
import com.logicorp.rfid.service.RfidEventService;
import org.springframework.stereotype.Component;

@Component
public class MLEngine {

    private final RfidEventService eventService;

    public MLEngine(RfidEventService eventService) {
        this.eventService = eventService;
    }

    public PredictionResult predict(RfidTag tag) {

        // FUTURO: converter eventos → INDArray → DL4J
        return new PredictionResult(
                tag.getTagId(),
                "warehouse-b",
                "ML",
                0.92
        );
    }
}