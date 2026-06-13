package com.triminds.tlp.prediction.service;

import com.triminds.tlp.prediction.dto.PredictionRequest;
import com.triminds.tlp.prediction.dto.PredictionResult;
import com.triminds.tlp.prediction.entity.Prediction;
import com.triminds.tlp.prediction.repository.PredictionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PredictionService {

    private final MLEngine mlEngine;
    private final PredictionRepository predictionRepository;

    @Transactional
    public PredictionResult makePrediction(PredictionRequest request) {
        PredictionResult result = mlEngine.predictDemand(request.getContext());

        Prediction prediction = new Prediction();
        prediction.setCompanyId(request.getCompanyId());
        prediction.setPredictionType(request.getPredictionType());
        prediction.setInputFeatures(request.getContext());
        prediction.setConfidence(result.getConfidence());
        prediction.setResult(result.getPrediction());
        prediction.setCreatedAt(LocalDateTime.now());
        prediction.setValidUntil(LocalDateTime.now().plusHours(6));

        predictionRepository.save(prediction);

        return result;
    }

    public List<Prediction> getRecentPredictions(String companyId, int limit) {
        return predictionRepository.findTopByCompanyIdOrderByCreatedAtDesc(companyId, limit);
    }
}
