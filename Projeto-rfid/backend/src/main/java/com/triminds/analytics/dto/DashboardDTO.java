package com.logicorp.analytics.dto;

public class DashboardDTO {

    private WarehouseKpiDTO warehouse;

    private ShipmentKpiDTO shipment;

    private PredictionKpiDTO prediction;

    public DashboardDTO() {
    }

    public DashboardDTO(
            WarehouseKpiDTO warehouse,
            ShipmentKpiDTO shipment,
            PredictionKpiDTO prediction) {

        this.warehouse = warehouse;
        this.shipment = shipment;
        this.prediction = prediction;
    }

    // getters/setters
}