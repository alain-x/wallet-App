package com.example.wallet.app.service;


import com.example.wallet.app.entities.Account;
import com.example.wallet.app.entities.Budget;
import com.example.wallet.app.entities.Transaction;
import com.example.wallet.app.repository.AccountRepo;
import com.example.wallet.app.repository.BudgetRepo;
import com.example.wallet.app.repository.TransactionRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletService {
    private final AccountRepo  accountRepo;
    private final TransactionRepo transactionRepo;
    private final BudgetRepo budgetRepo;

    public WalletService(AccountRepo accountRepo, TransactionRepo transactionRepo, BudgetRepo budgetRepo) {
        this.accountRepo = accountRepo;
        this.transactionRepo = transactionRepo;
        this.budgetRepo = budgetRepo;
    }

    public List<Account> getAllAccounts() {
        return accountRepo.findAll();
    }

    public Account saveAccount(Account account) {
        return accountRepo.save(account);
    }

    public List<Transaction> getTransactionsByCategory(String category) {
        return transactionRepo.findByCategory(category);
    }

    public Transaction saveTransaction(Transaction transaction) {
        updateBudget(transaction);
        return transactionRepo.save(transaction);
    }

    private void updateBudget(Transaction transaction) {
        if ("expense".equalsIgnoreCase(transaction.getTransactionType())) {
            budgetRepo.findByCategory(transaction.getCategory()).ifPresent(budget -> {
                budget.setCurrentSpending(budget.getCurrentSpending() + transaction.getAmount());
                if (budget.getCurrentSpending() > budget.getLimitAmount()) {
                    System.out.println("Budget exceeded for category: " + transaction.getCategory());
                }
                budgetRepo.save(budget);
            });
        }
    }

    public Budget saveBudget(Budget budget) {
        return budgetRepo.save(budget);
    }

    public List<Budget> getAllBudgets() {
        return budgetRepo.findAll();
    }
}
