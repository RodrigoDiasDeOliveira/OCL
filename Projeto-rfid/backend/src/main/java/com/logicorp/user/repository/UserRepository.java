package com.logicorp.user.repository;

import com.logicorp.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository
        extends JpaRepository<User, UUID> {

}