package com.logicorp.warehouse.model;

import com.logicorp.company.Company;
import jakarta.persistence.*;

@Entity
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;

    @ManyToOne
    private Company company;
}