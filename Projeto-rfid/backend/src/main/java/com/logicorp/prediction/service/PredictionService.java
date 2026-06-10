package com.logicorp.prediction.service;

import com.logicorp.rfid.model.RfidTag;
import org.springframework.stereotype.Service;

@Service
public class PredictionService {

    public String predictNextLocation(RfidTag tag) {

        // lógica simples inicial (placeholder inteligente)
        String current = tag.getLocation();

        // exemplo de regra inicial evolutiva
        if (current == null) return "UNKNOWN";

        if (current.equalsIgnoreCase("warehouse-a")) {
            return "warehouse-b";
        }

        if (current.equalsIgnoreCase("warehouse-b")) {
            return "shipping-zone";
        }

        return "analysis-required";
    }
}