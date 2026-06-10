package com.triminds.analytics.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BottleneckDetectionService {

    public String detectBottleneck(List<Long> processingTimes) {

        long avg = processingTimes.stream()
                .mapToLong(v -> v)
                .sum() / processingTimes.size();

        if (avg > 50) {
            return "CRITICAL_BOTTLENECK";
        }

        return "NORMAL_FLOW";
    }
}