package com.example.wallet.app.controller;

import com.example.wallet.app.entities.Account;
import com.example.wallet.app.entities.Budget;
import com.example.wallet.app.entities.Transaction;
import com.example.wallet.app.service.WalletService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class WalletController {
    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping("/accounts")
    public List<Account> getAccounts() {
        return walletService.getAllAccounts();
    }

    @PostMapping("/accounts")
    public Account addAccount(@RequestBody Account account) {
        return walletService.saveAccount(account);
    }

    @GetMapping("/transactions/{category}")
    public List<Transaction> getTransactions(@PathVariable String category) {
        return walletService.getTransactionsByCategory(category);
    }

    @PostMapping("/transactions")
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return walletService.saveTransaction(transaction);
    }

    @GetMapping("/budgets")
    public List<Budget> getBudgets() {
        return walletService.getAllBudgets();
    }

    @PostMapping("/budgets")
    public Budget addBudget(@RequestBody Budget budget) {
        return walletService.saveBudget(budget);
    }
}