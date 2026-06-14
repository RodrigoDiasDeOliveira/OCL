package com.triminds.tlp.company.repository;

import com.triminds.tlp.company.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import java.Optional;
import java.util.UUID;

public interface CompanyRepository
        extends JpaRepository<Company, UUID> {
        Optional<Company> findByTenantId(String tenantId);
}