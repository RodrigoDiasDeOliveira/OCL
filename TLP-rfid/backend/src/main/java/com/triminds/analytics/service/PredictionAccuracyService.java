package com.triminds.analytics.service;

import com.triminds.prediction.engine.HistoricalEngine;
import org.springframework.stereotype.Service;

@Service
public class PredictionAccuracyService {

    private final HistoricalEngine historicalEngine;

    public PredictionAccuracyService(HistoricalEngine historicalEngine) {
        this.historicalEngine = historicalEngine;
    }

    public double calculateAccuracy() {

        long events = historicalEngine.countEventsLast24h();

        long shipments = historicalEngine.countShipments();

        if (events == 0) return 0;

        return (double) shipments / events;
    }
}