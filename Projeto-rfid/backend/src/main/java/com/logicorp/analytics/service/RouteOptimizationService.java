package com.logicorp.analytics.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteOptimizationService {

    public List<String> optimizeRoute(List<String> zones) {

        // versão inicial (heurística simples)

        return zones.stream()
                .sorted()
                .toList();
    }
}