package com.example.wallet.app.repository;


import com.example.wallet.app.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Long> {
}
