package com.triminds.prediction.model;

import java.time.LocalDateTime;

public class PredictionResult {

    private String entityId; // tagId, shipmentId etc
    private String type;     // RFID / SHIPMENT / STOCK

    private double score;

    private String prediction;

    private LocalDateTime timestamp = LocalDateTime.now();

    public PredictionResult(String entityId, String type, double score, String prediction) {
        this.entityId = entityId;
        this.type = type;
        this.score = score;
        this.prediction = prediction;
    }

    // getters/setters
}