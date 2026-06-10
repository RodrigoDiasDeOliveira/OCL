package com.logicorp.shipment.repository;

import com.logicorp.shipment.model.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShipmentRepository extends JpaRepository<Shipment, UUID> {

    List<Shipment> findByStatus(String status);

    List<Shipment> findByCompanyId(UUID companyId);
}