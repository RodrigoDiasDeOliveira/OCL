package com.triminds.tlp.prediction.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prediction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyId;
    private String predictionType; // DEMAND, LOCATION, DELAY, INVENTORY

    @Column(columnDefinition = "TEXT")
    private String inputFeatures;

    private Double confidence;
    private String result;

    private LocalDateTime createdAt;
    private LocalDateTime validUntil;
}