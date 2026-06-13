package com.triminds.tlp.integration.service;

import com.triminds.tlp.rfid.model.RfidEvent;
import com.triminds.tlp.rfid.repository.RfidEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventIngestionService {

    private final RfidEventRepository rfidRepository;

    public RfidEvent processRfidEvent(RfidEvent event) {
        if (event.getTimestamp() == null) {
            event.setTimestamp(LocalDateTime.now());
        }
        return rfidRepository.save(event);
    }

    public int processBatch(List<RfidEvent> events) {
        events.forEach(event -> {
            if (event.getTimestamp() == null) {
                event.setTimestamp(LocalDateTime.now());
            }
        });
        rfidRepository.saveAll(events);
        return events.size();
    }
}