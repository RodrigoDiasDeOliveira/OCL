package com.triminds.tlp.company.controller;

import com.triminds.tlp.company.model.Company;
import com.triminds.tlp.company.service.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    private final CompanyService service;

    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @PostMapping
    public Company save(@RequestBody Company company) {
        return service.save(company);
    }

    @GetMapping
    public List<Company> findAll() {
        return service.findAll();
    }
}