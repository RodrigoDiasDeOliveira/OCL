package com.logicorp.rfid.repository;

import com.logicorp.rfid.model.RfidEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RfidEventRepository extends JpaRepository<RfidEvent, Long> {

    List<RfidEvent> findByTagIdOrderByTimestampAsc(String tagId);

    List<RfidEvent> findByTagId(String tagId);
}