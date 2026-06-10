package com.logicorp.prediction.model;

import java.time.LocalDateTime;

public class PredictionResult {

    private String productId;
    private double predictedDemand;
    private LocalDateTime predictionTimestamp;

    public PredictionResult(String productId, double predictedDemand) {
        this.productId = productId;
        this.predictedDemand = predictedDemand;
        this.predictionTimestamp = LocalDateTime.now();
    }

    // getters/setters
}