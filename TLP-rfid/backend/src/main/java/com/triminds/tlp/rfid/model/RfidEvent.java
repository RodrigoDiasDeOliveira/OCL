package com.triminds.tlp.rfid.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "rfid_events")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RfidEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tagId;

    private String location;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EventType eventType;

    private LocalDateTime timestamp = LocalDateTime.now();

    public RfidEvent(String tagId, String location, EventType eventType) {
        this.tagId = tagId;
        this.location = location;
        this.eventType = eventType;
        this.timestamp = LocalDateTime.now();
    }
}