package com.triminds.tlp.rfid.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "rfid_events")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RfidEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tagId;

    @Column(nullable = false)
    private String readerId;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Enumerated(EnumType.STRING)
    private EventType eventType; // READ, ENTER, EXIT, LOCATION

    private String location;     // zona/armazém
    private String productCode;
    private String companyId;

    @Column(columnDefinition = "json")
    private String metadata;     // dados extras do leitor
}

public enum EventType {
    READ, ENTER, EXIT, LOCATION
}