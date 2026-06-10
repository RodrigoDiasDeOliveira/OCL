package com.logicorp.rfid.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RfidEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tagId;
    private String location;
    private String eventType; // IN, OUT, MOVE, SCAN

    private LocalDateTime timestamp = LocalDateTime.now();

    public RfidEvent() {}

    public RfidEvent(String tagId, String location, String eventType) {
        this.tagId = tagId;
        this.location = location;
        this.eventType = eventType;
        this.timestamp = LocalDateTime.now();
    }

    // getters/setters
}