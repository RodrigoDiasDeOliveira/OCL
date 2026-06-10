package com.triminds.analytics.service;

import com.triminds.analytics.dto.WarehouseKpiDTO;
import org.springframework.stereotype.Service;

@Service
public class WarehouseKpiService {

    public WarehouseKpiDTO generateKpi(String warehouseName) {

        return new WarehouseKpiDTO(
                warehouseName,
                1500,
                62.5,
                74.0
        );
    }
}