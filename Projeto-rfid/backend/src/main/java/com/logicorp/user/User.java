package com.logicorp.user;

import com.logicorp.company.Company;
import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String role;

    @ManyToOne
    private Company company;
}