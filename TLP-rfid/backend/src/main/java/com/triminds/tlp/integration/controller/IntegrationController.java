package com.triminds.tlp.integration.controller;

import com.triminds.tlp.integration.dto.ExternalShipmentDTO;
import com.triminds.tlp.integration.service.IntegrationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/integration")
public class IntegrationController {

    private final IntegrationService service;

    public IntegrationController(IntegrationService service) {
        this.service = service;
    }

    // 📦 ERP → sistema
    @PostMapping("/shipment")
    public void ingestShipment(@RequestBody ExternalShipmentDTO dto) {
        service.ingestShipment(dto);
    }

    // 📡 eventos externos
    @PostMapping("/rfid-event")
    public void ingestEvent(
            @RequestParam String tagId,
            @RequestParam String location,
            @RequestParam String type
    ) {
        service.ingestRfidEvent(tagId, location, type);
    }
}