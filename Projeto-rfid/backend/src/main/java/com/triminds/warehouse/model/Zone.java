package com.logicorp.warehouse.model;

import jakarta.persistence.*;

@Entity
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // RECEIVING, STORAGE, SHIPPING

    @ManyToOne
    private Warehouse warehouse;
}