package com.example.wallet.app.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Budget")
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double limitAmount;
    private Double currentSpending;

    private String category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLimitAmount() {
        return limitAmount;
    }

    public void setLimitAmount(Double limitAmount) {
        this.limitAmount = limitAmount;
    }

    public Double getCurrentSpending() {
        return currentSpending;
    }

    public void setCurrentSpending(Double currentSpending) {
        this.currentSpending = currentSpending;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}