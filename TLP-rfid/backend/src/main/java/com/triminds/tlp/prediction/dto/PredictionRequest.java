package com.triminds.tlp.prediction.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PredictionRequest {
    private String productId;
    private double demand;
    private int horizonDays;
    // adicione outros campos conforme necessário
}
