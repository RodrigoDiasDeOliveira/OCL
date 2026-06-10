package com.triminds.shipment.controller;

import com.triminds.shipment.model.Shipment;
import com.triminds.shipment.service.ShipmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipment")
public class ShipmentController {

    private final ShipmentService service;

    public ShipmentController(ShipmentService service) {
        this.service = service;
    }

    @PostMapping
    public Shipment save(@RequestBody Shipment shipment) {
        return service.save(shipment);
    }

    @GetMapping
    public List<Shipment> findAll() {
        return service.findAll();
    }
}