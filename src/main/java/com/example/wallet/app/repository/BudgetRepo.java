package com.example.wallet.app.repository;


import com.example.wallet.app.entities.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BudgetRepo extends JpaRepository<Budget, Long> {
    Optional<Budget> findByCategory(String category);
}
