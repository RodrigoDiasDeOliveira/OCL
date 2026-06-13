package com.triminds.tlp.prediction.controller;

import com.triminds.tlp.rfid.model.RfidTag;
import com.triminds.tlp.prediction.service.PredictionService;
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