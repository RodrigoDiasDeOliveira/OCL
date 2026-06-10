package com.logicorp.analytics.dto;

public class ShipmentKpiDTO {

    private long totalShipments;

    private long deliveredShipments;

    private long delayedShipments;

    public ShipmentKpiDTO() {
    }

    public ShipmentKpiDTO(
            long totalShipments,
            long deliveredShipments,
            long delayedShipments) {

        this.totalShipments = totalShipments;
        this.deliveredShipments = deliveredShipments;
        this.delayedShipments = delayedShipments;
    }

    // getters/setters
}