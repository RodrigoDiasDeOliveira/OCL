package com.triminds.analytics.dto;

public class PredictionKpiDTO {

    private double accuracy;

    private long predictions;

    private long correctPredictions;

    public PredictionKpiDTO() {
    }

    public PredictionKpiDTO(
            double accuracy,
            long predictions,
            long correctPredictions) {

        this.accuracy = accuracy;
        this.predictions = predictions;
        this.correctPredictions = correctPredictions;
    }

    // getters/setters
}