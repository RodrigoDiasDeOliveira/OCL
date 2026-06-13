package com.triminds.tlp.rfid.service;

import com.triminds.tlp.rfid.model.RfidEvent;
import com.triminds.tlp.rfid.repository.RfidEventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RfidEventService {

    private final RfidEventRepository repository;

    public RfidEventService(RfidEventRepository repository) {
        this.repository = repository;
    }

    public void registerEvent(String tagId, String location, String type) {
        repository.save(new RfidEvent(tagId, location, type));
    }

    public List<RfidEvent> getHistory(String tagId) {
        return repository.findByTagIdOrderByTimestampAsc(tagId);
    }
}