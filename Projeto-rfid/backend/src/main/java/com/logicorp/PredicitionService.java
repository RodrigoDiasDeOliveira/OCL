package com.logicorp;

import org.springframework.stereotype.Service;

@Service
public class PredictionService {
    
    public String predictNextLocation(RfidTag tag) {
        // Exemplo simples de previsão (pode ser substituído por lógica de machine learning)
        return "Localidade Prevista para " + tag.getProductName();
    }
    public PredictionResult predictDemand(String productId) {
        // Simulação de previsão de demanda (exemplo)
        double predictedDemand = Math.random() * 100; // Aqui  integrar outro modelo de IA real

        return new PredictionResult(productId, predictedDemand);
    }
}
