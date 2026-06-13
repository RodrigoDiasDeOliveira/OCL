package com.triminds.tlp.integration.client;

import org.springframework.stereotype.Component;

@Component
public class ERPClient {

    public String fetchShipments() {
        // FUTURO: REST / SOAP / GraphQL
        return "external-data";
    }
}