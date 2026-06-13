package com.triminds.tlp.shipment.service;

import com.triminds.tlp.shipment.model.Shipment;
import com.triminds.tlp.shipment.repository.ShipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentService {

    private final ShipmentRepository repository;

    public ShipmentService(ShipmentRepository repository) {
        this.repository = repository;
    }

    public Shipment save(Shipment shipment) {
        return repository.save(shipment);
    }

    public List<Shipment> findAll() {
        return repository.findAll();
    }
}