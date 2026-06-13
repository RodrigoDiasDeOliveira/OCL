package com.triminds.tlp.analytics.service;

import com.triminds.tlp.analytics.dto.WarehouseKpiDTO;
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