package com.triminds.integration.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RfidEventDTO {

    private String tagId;
    private String location;
    private String action;
    private String item;
    private LocalDateTime timestamp;
    private String status; // success, warning, error

    // Construtor padrão
    public RfidEventDTO() {}

    public RfidEventDTO(String tagId, String location, String action, String item) {
        this.tagId = tagId;
        this.location = location;
        this.action = action;
        this.item = item;
        this.timestamp = LocalDateTime.now();
        this.status = "success";
    }
}