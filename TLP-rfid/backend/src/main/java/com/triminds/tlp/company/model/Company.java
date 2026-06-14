package com.triminds.tlp.company.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String taxId;

    @Column(unique = true, nullable = false)
    private String tenantId;

    private LocalDateTime createdAt = LocalDateTime.now();
}