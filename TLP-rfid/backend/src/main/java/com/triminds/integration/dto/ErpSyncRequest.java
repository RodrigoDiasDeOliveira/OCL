package com.triminds.integration.dto;

import lombok.Data;

@Data
public class ErpSyncRequest {
    private String erp;      // oracle, sap, totvs
    private String entity;   // inventory, sales, orders, shipments...
    private String dateFrom;
    private String dateTo;
}