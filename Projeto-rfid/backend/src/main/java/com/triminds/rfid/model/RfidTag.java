package com.logicorp.rfid.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@Getter
@Setter
public class RfidTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tagId;
    private String productName;
    private String location;
    private LocalDateTime lastScanned;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTagId() { return tagId; }
    public void setTagId(String tagId) { this.tagId = tagId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public LocalDateTime getLastScanned() { return lastScanned; }
    public void setLastScanned(LocalDateTime lastScanned) { this.lastScanned = lastScanned; }
}