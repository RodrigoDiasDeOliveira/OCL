package com.triminds.analytics.service;

import com.triminds.analytics.dto.DashboardDTO;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsService {

    private final DashboardService dashboardService;

    public AnalyticsService(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    public DashboardDTO getDashboard() {
        return dashboardService.buildDashboard();
    }
}