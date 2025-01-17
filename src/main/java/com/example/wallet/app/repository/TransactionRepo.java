package com.example.wallet.app.repository;

import com.example.wallet.app.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {

    List<Transaction> findByCategory(String category);
}
