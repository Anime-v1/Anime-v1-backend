package com.example.animev1backend.repository;

import com.example.animev1backend.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAcountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUsername(String username);
}
