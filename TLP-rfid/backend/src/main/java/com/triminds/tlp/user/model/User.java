package com.triminds.tlp.user.model;

import com.triminds.tlp.company.Company;
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