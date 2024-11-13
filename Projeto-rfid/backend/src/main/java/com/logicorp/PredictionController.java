package com.logicorp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/predict")
public class PredictionController {

    @Autowired
    private PredictionService predictionService;

    @PostMapping
    public String predictLocation(@RequestBody RfidTag tag) {
        return predictionService.predictNextLocation(tag);
    }
}
