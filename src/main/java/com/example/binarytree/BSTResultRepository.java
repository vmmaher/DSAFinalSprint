package com.example.binarytree;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BSTResultRepository extends JpaRepository<BSTResult, Long> {
    // No extra methods needed for now
}
