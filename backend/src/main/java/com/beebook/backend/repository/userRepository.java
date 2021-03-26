package com.beebook.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beebook.backend.model.users;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
public interface userRepository extends JpaRepository<users, Integer> {
    
}
