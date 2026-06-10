package com.triminds.prediction.engine;

import com.triminds.prediction.model.PredictionResult;
import org.springframework.stereotype.Service;

@Service
public class MLEngine {

    public PredictionResult predict(String entityId, String context) {

        double score = Math.random(); // substitui depois por DL4J real

        String prediction;

        if (score > 0.8) {
            prediction = "HIGH_ACTIVITY";
        } else if (score > 0.5) {
            prediction = "MEDIUM_ACTIVITY";
        } else {
            prediction = "LOW_ACTIVITY";
        }

        return new PredictionResult(
                entityId,
                context,
                score,
                prediction
        );
    }
}