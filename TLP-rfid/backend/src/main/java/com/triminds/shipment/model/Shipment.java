package com.triminds.shipment;

import com.triminds.company.Company;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String origin;
    private String destination;
    private String status;

    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    private Company company;
}