package com.triminds.shipment.repository;

import com.triminds.shipment.model.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShipmentRepository extends JpaRepository<Shipment, UUID> {

    List<Shipment> findByStatus(String status);

    List<Shipment> findByCompanyId(UUID companyId);
}