package com.logicorp.company;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String taxId;
    private LocalDateTime createdAt = LocalDateTime.now();
}