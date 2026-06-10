package com.triminds.warehouse.service;

import com.triminds.warehouse.model.Warehouse;
import com.triminds.warehouse.repository.WarehouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseService {

    private final WarehouseRepository repository;

    public WarehouseService(WarehouseRepository repository) {
        this.repository = repository;
    }

    public Warehouse save(Warehouse warehouse) {
        return repository.save(warehouse);
    }

    public List<Warehouse> findAll() {
        return repository.findAll();
    }
}