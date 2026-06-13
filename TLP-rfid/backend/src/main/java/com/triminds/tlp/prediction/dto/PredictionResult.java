package com.triminds.tlp.prediction.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PredictionRequest {
    private String companyId;
    private String predictionType;
    private String context; // JSON com dados atuais
}

@Data
public class PredictionResult {
    private String prediction;
    private double confidence;
    private String explanation;
}