package com.logicorp.integration.service;

import com.logicorp.integration.dto.ExternalShipmentDTO;
import com.logicorp.rfid.service.RfidEventService;
import org.springframework.stereotype.Service;

@Service
public class IntegrationService {

    private final RfidEventService eventService;

    public IntegrationService(RfidEventService eventService) {
        this.eventService = eventService;
    }

    // 📦 recebe dados de ERP
    public void ingestShipment(ExternalShipmentDTO dto) {

        // normalização simples inicial
        System.out.println("Integrando shipment externo: " + dto.getExternalId());

        // futuro: mapear para Shipment interno
    }

    // 📡 recebe eventos externos (IoT / parceiros)
    public void ingestRfidEvent(String tagId, String location, String type) {

        eventService.registerEvent(tagId, location, type);
    }
}