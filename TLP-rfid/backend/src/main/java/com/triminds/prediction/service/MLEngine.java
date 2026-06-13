package com.triminds.tlp.prediction.service;

import com.triminds.tlp.prediction.dto.PredictionResult;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.springframework.stereotype.Service;

@Service
public class MLEngine {

    // Em produção você carregaria o modelo treinado
    private MultiLayerNetwork model; // inicializado no @PostConstruct ou via job

    public PredictionResult predictDemand(String contextJson) {
        // Exemplo simples - substitua por feature engineering real
        double[] features = {0.8, 45.0, 120, 3}; // exemplo: stock, temp, hour, dayOfWeek
        INDArray input = Nd4j.create(features).reshape(1, features.length);

        // INDArray output = model.output(input); // quando modelo estiver treinado

        return new PredictionResult(
            "ALTO",
            0.87,
            "Baseado em histórico de movimento na zona A + horário de pico"
        );
    }
}
