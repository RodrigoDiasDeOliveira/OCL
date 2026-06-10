package com.logicorp.warehouse.repository;

import com.logicorp.warehouse.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WarehouseRepository extends JpaRepository<Warehouse, UUID> {

    List<Warehouse> findByCompanyId(UUID companyId);
}