package com.triminds.shipment;

import jakarta.persistence.*;

@Entity
public class ShipmentItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tagId;
    private Integer quantity;

    @ManyToOne
    private Shipment shipment;
}