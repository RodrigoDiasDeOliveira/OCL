package com.triminds.analytics.service;

import com.triminds.prediction.engine.MLEngine;
import com.triminds.prediction.model.PredictionResult;
import org.springframework.stereotype.Service;

@Service
public class InventoryForecastService {

    private final MLEngine mlEngine;

    public InventoryForecastService(MLEngine mlEngine) {
        this.mlEngine = mlEngine;
    }

    public PredictionResult forecast(String productId) {

        return mlEngine.predict(productId, "INVENTORY");
    }
}