package com.triminds.tlp.analytics.service;

import com.triminds.tlp.analytics.dto.ShipmentKpiDTO;
import org.springframework.stereotype.Service;

@Service
public class ShipmentKpiService {

    public ShipmentKpiDTO calculate() {

        return new ShipmentKpiDTO(
                1200,
                1140,
                60
        );
    }
}