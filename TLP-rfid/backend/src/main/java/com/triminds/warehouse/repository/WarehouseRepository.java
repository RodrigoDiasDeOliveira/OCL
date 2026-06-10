package com.triminds.warehouse.repository;

import com.triminds.warehouse.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WarehouseRepository extends JpaRepository<Warehouse, UUID> {

    List<Warehouse> findByCompanyId(UUID companyId);
}