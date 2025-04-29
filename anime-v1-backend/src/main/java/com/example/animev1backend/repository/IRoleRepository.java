package com.example.animev1backend.repository;

import com.example.animev1backend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Long> {
}
