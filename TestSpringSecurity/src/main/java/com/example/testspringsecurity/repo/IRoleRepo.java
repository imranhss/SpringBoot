package com.example.testspringsecurity.repo;

import com.example.testspringsecurity.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepo extends JpaRepository<Role, Integer > {
}
