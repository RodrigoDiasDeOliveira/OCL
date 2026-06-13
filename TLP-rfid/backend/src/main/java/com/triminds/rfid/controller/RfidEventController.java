
package com.triminds.tlp.rfid.controller;

import com.triminds.tlp.rfid.dto.RfidEventDTO;
import com.triminds.tlp.rfid.entity.RfidEvent;
import com.triminds.tlp.rfid.service.RfidEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/rfid")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RfidEventController {

    private final RfidEventService rfidEventService;

    @PostMapping("/events/ingest")
    public ResponseEntity<Void> ingestEvents(@RequestBody List<RfidEventDTO> events) {
        rfidEventService.ingestEvents(events);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/events/realtime")
    public ResponseEntity<List<RfidEvent>> getRealTimeEvents(
            @RequestParam String companyId,
            @RequestParam(defaultValue = "50") int limit) {
        return ResponseEntity.ok(rfidEventService.getRealTimeEvents(companyId, limit));
    }

    @GetMapping("/kpis")
    public ResponseEntity<Map<String, Object>> getKpis(@RequestParam String companyId) {
        // Integra com AnalyticsService
        return ResponseEntity.ok(Map.of("status", "ok", "companyId", companyId));
    }
}
