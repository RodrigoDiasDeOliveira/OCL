package com.logicorp.prediction.service;

import com.logicorp.rfid.model.RfidTag;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PredictionService {

    // 🔵 futuro: injetar histórico real (RfidEventService)
    // private final RfidEventService eventService;

    // 🔵 futuro: modelo ML
    // private final LocationPredictionModel mlModel;

    public PredictionService() {
        // inicialização futura
        // this.mlModel = new LocationPredictionModel();
    }

    /**
     * 🧠 PONTO PRINCIPAL DO SISTEMA
     * Decidir entre regra simples ou IA futura
     */
    public String predictNextLocation(RfidTag tag) {

        if (tag == null) {
            return "UNKNOWN";
        }

        if (tag.getLocation() == null) {
            return "UNKNOWN";
        }

        // 🔵 FASE 1: regras atuais (SEMPRE FUNCIONA)
        if (isRuleBasedApplicable(tag)) {
            return ruleBasedPrediction(tag);
        }

        // 🟡 FASE 2 (futuro): decisão com histórico
        if (hasHistoricalData(tag)) {
            return historicalPrediction(tag);
        }

        // 🔵 fallback seguro
        return ruleBasedPrediction(tag);
    }

    // ---------------------------------------------------
    // 🟢 LÓGICA ATUAL (SISTEMA JÁ FUNCIONANDO)
    // ---------------------------------------------------
    private String ruleBasedPrediction(RfidTag tag) {

        String current = tag.getLocation();

        if (current.equalsIgnoreCase("warehouse-a")) {
            return "warehouse-b";
        }

        if (current.equalsIgnoreCase("warehouse-b")) {
            return "shipping-zone";
        }

        if (current.equalsIgnoreCase("shipping-zone")) {
            return "in-transit";
        }

        return "analysis-required";
    }

    // ---------------------------------------------------
    // 🟡 FUTURO: HISTÓRICO (EVENTOS RFID)
    // ---------------------------------------------------
    private String historicalPrediction(RfidTag tag) {

        // placeholder para evolução real
        // aqui entrará análise de RfidEvent:
        // - frequência de rota
        // - tempo médio por zona
        // - padrões de movimentação

        return ruleBasedPrediction(tag);
    }

    // ---------------------------------------------------
    // 🧠 DECISÃO DE USO DE REGRAS
    // ---------------------------------------------------
    private boolean isRuleBasedApplicable(RfidTag tag) {

        // regra simples: se ainda não temos dados suficientes
        return true;
    }

    // ---------------------------------------------------
    // 📊 VERIFICA SE HÁ HISTÓRICO
    // ---------------------------------------------------
    private boolean hasHistoricalData(RfidTag tag) {

        // futuro: consultar RfidEventService
        return false;
    }
}