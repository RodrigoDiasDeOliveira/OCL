package com.triminds.tlp.integration.client;

import org.springframework.stereotype.Component;

@Component
public class WMSClient {

    public String getWarehouseStatus() {
        return "warehouse-status";
    }
}