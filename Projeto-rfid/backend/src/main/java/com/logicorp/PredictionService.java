package com.logicorp;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PredictionService {

    // Modelos de ML desativados temporariamente
    // private LocationPredictionModel locationModel;
    // private DemandPredictionModel demandModel;

    public PredictionService() {
        // Inicialização dos modelos comentada
        // locationModel = new LocationPredictionModel();
        // demandModel = new DemandPredictionModel();
    }

    public String predictNextLocation(RfidTag tag) {
        // Versão simplificada sem ML
        return "Previsão simulada: " + tag.getProductName() + 
               " provavelmente ainda está em " + tag.getLocation();
    }

    public PredictionResult predictDemand(String productId) {
        // Versão simulada
        double simulatedDemand = Math.random() * 100 + 50; // entre 50 e 150
        return new PredictionResult(productId, simulatedDemand);
    }

    // Métodos auxiliares removidos ou comentados...
}