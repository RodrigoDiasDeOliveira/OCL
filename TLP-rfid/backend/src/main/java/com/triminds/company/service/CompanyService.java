package com.triminds.company.service;

import com.triminds.company.model.Company;
import com.triminds.company.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CompanyService {

    private final CompanyRepository repository;

    public CompanyService(CompanyRepository repository) {
        this.repository = repository;
    }

    public Company save(Company company) {
        return repository.save(company);
    }

    public List<Company> findAll() {
        return repository.findAll();
    }

    public Company findById(UUID id) {
        return repository.findById(id)
                .orElseThrow();
    }
}