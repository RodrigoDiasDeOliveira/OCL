package com.triminds.analytics.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HeatMapService {

    public Map<String, Integer> calculateZoneHeatMap() {

        Map<String, Integer> heatMap = new HashMap<>();

        heatMap.put("ZONE_A", 1200);
        heatMap.put("ZONE_B", 800);
        heatMap.put("ZONE_C", 450);

        return heatMap;
    }
}