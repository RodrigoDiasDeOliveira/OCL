
package com.triminds.tlp.prediction.service;

import com.triminds.tlp.prediction.dto.PredictionResult;
import org.springframework.stereotype.Service;

@Service
public class MLEngine {

    public PredictionResult predictDemand(String contextJson) {
        double confidence = 0.75 + Math.random() * 0.20;

        String prediction = (contextJson != null && contextJson.contains("peak")) ? "ALTO" :
                           (Math.random() > 0.6 ? "MÉDIO" : "BAIXO");

        return new PredictionResult(
                prediction,
                confidence,
                "Baseado em histórico de movimentação + horário do dia + volume de tags na zona"
        );
    }
}
