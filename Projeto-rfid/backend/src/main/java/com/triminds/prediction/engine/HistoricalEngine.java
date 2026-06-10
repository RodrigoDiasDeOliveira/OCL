package com.logicorp.prediction.engine;

import com.logicorp.rfid.repository.RfidEventRepository;
import com.logicorp.shipment.repository.ShipmentRepository;
import org.springframework.stereotype.Service;

@Service
public class HistoricalEngine {

    private final RfidEventRepository rfidRepo;
    private final ShipmentRepository shipmentRepo;

    public HistoricalEngine(
            RfidEventRepository rfidRepo,
            ShipmentRepository shipmentRepo) {

        this.rfidRepo = rfidRepo;
        this.shipmentRepo = shipmentRepo;
    }

    public long countEventsLast24h() {
        return rfidRepo.findAll().size();
    }

    public long countShipments() {
        return shipmentRepo.findAll().size();
    }
}