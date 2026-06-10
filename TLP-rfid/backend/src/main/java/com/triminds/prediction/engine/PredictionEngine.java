package com.triminds.prediction.engine;

import com.triminds.rfid.model.RfidTag;
import org.springframework.stereotype.Service;

@Service
public class PredictionEngine {

    private final RuleEngine ruleEngine;
    private final HistoricalEngine historicalEngine;
    private final MLEngine mlEngine;

    public PredictionEngine(
            RuleEngine ruleEngine,
            HistoricalEngine historicalEngine,
            MLEngine mlEngine
    ) {
        this.ruleEngine = ruleEngine;
        this.historicalEngine = historicalEngine;
        this.mlEngine = mlEngine;
    }

    public PredictionResult predict(RfidTag tag) {

        // 🔵 1. ML se houver confiança futura
        if (hasMLCapability(tag)) {
            return mlEngine.predict(tag);
        }

        // 🟡 2. histórico REAL (AGORA CONECTADO)
        if (hasHistory(tag)) {
            return historicalEngine.predict(tag);
        }

        // 🟢 3. fallback seguro
        return ruleEngine.predict(tag);
    }

    private boolean hasMLCapability(RfidTag tag) {
        return false;
    }

    private boolean hasHistory(RfidTag tag) {
        return true; // agora sempre consulta eventos
    }
}