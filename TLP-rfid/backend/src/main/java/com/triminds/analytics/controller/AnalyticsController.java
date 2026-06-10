package com.triminds.analytics.controller;

import com.triminds.analytics.dto.DashboardDTO;
import com.triminds.analytics.service.AnalyticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    public AnalyticsController(
            AnalyticsService analyticsService) {

        this.analyticsService = analyticsService;
    }

    @GetMapping("/api/analytics/dashboard")
    public DashboardDTO dashboard() {
        return analyticsService.getDashboard();
    }
}