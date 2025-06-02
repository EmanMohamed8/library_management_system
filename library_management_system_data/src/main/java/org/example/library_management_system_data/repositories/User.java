package org.example.library_management_system_data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface User extends JpaRepository<User, Long> {
    public Optional <User> findByEmail(String email);
}
