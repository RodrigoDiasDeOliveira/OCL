package com.triminds.tlp.analytics.service;

import com.triminds.tlp.analytics.dto.*;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    private final WarehouseKpiService warehouseKpiService;
    private final ShipmentKpiService shipmentKpiService;
    private final PredictionAccuracyService predictionAccuracyService;

    public DashboardService(
            WarehouseKpiService warehouseKpiService,
            ShipmentKpiService shipmentKpiService,
            PredictionAccuracyService predictionAccuracyService) {

        this.warehouseKpiService = warehouseKpiService;
        this.shipmentKpiService = shipmentKpiService;
        this.predictionAccuracyService = predictionAccuracyService;
    }

    public DashboardDTO buildDashboard() {

        return new DashboardDTO(
                warehouseKpiService.generateKpi("MAIN-WAREHOUSE"),
                shipmentKpiService.calculate(),
                predictionAccuracyService.calculateAccuracy()
        );
    }
}