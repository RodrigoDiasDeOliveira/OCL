package com.triminds.tlp.integration.controller;

import com.triminds.tlp.integration.dto.RfidEventDTO;
import com.triminds.tlp.integration.mapper.IntegrationMapper;
import com.triminds.tlp.integration.service.EventIngestionService;
import com.triminds.tlp.rfid.model.RfidEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/integration/events")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EventIngestionController {

    private final EventIngestionService eventService;
    private final IntegrationMapper mapper;

    @PostMapping("/rfid")
    public ResponseEntity<RfidEvent> receiveRfidEvent(@RequestBody RfidEventDTO dto) {
        RfidEvent entity = mapper.toEntity(dto);
        RfidEvent saved = eventService.processRfidEvent(entity);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/batch")
    public ResponseEntity<String> receiveBatch(@RequestBody List<RfidEventDTO> dtos) {
        List<RfidEvent> entities = mapper.toEntityList(dtos);
        int count = eventService.processBatch(entities);
        return ResponseEntity.ok(count + " eventos RFID processados com sucesso.");
    }
}