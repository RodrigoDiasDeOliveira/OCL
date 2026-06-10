package com.triminds.prediction.controller;

import com.triminds.rfid.model.RfidTag;
import com.triminds.prediction.service.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/predict")
public class PredictionController {

    @Autowired
    private PredictionService predictionService;

    @PostMapping("/location")
    public String predictLocation(@RequestBody RfidTag tag) {
        return predictionService.predictNextLocation(tag);
    }
}