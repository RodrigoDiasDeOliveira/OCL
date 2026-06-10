package com.logicorp.company.repository;

import com.logicorp.company.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompanyRepository
        extends JpaRepository<Company, UUID> {

}