package com.triminds.rfid.repository;

import com.triminds.rfid.model.RfidEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface RfidEventRepository extends JpaRepository<RfidEvent, UUID> {

    List<RfidEvent> findByLocation(String location);

    List<RfidEvent> findByTimestampBetween(LocalDateTime start, LocalDateTime end);

    List<RfidEvent> findByTagId(String tagId);
}