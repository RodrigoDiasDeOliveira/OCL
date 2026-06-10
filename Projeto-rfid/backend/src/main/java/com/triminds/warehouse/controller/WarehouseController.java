package com.logicorp.warehouse.controller;

import com.logicorp.warehouse.model.Warehouse;
import com.logicorp.warehouse.service.WarehouseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warehouse")
public class WarehouseController {

    private final WarehouseService service;

    public WarehouseController(WarehouseService service) {
        this.service = service;
    }

    @PostMapping
    public Warehouse save(@RequestBody Warehouse warehouse) {
        return service.save(warehouse);
    }

    @GetMapping
    public List<Warehouse> findAll() {
        return service.findAll();
    }
}