package com.triminds.company.repository;

import com.triminds.company.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompanyRepository
        extends JpaRepository<Company, UUID> {

}