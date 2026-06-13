package com.triminds.tlp.analytics.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CustomerBehaviorService {

    public String analyzeCustomer(Map<String, Integer> activity) {

        int total = activity.values().stream().mapToInt(i -> i).sum();

        if (total > 1000) {
            return "HIGH_VALUE_CUSTOMER";
        }

        if (total > 300) {
            return "ACTIVE_CUSTOMER";
        }

        return "LOW_ACTIVITY";
    }
}