package com.triminds.tlp.analytics.dto;

public class WarehouseKpiDTO {

    private String warehouseName;

    private long totalMovements;

    private double throughput;

    private double occupancyRate;

    public WarehouseKpiDTO() {
    }

    public WarehouseKpiDTO(
            String warehouseName,
            long totalMovements,
            double throughput,
            double occupancyRate) {

        this.warehouseName = warehouseName;
        this.totalMovements = totalMovements;
        this.throughput = throughput;
        this.occupancyRate = occupancyRate;
    }

    // getters/setters
}