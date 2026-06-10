package com.logicorp.prediction.controller;

import com.logicorp.rfid.model.RfidTag;
import com.logicorp.prediction.service.PredictionService;
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