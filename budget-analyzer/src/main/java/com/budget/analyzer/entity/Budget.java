package com.budget.analyzer.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Entity representing a user's budget.
 */
@Entity
@Table(name = "budgets")
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;

    private Double amount;

    private LocalDate month; // Represents the month for which this budget is set

    public Budget() {
    }

    public Budget(String category, Double amount, LocalDate month) {
        this.category = category;
        this.amount = amount;
        this.month = month;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getMonth() {
        return month;
    }

    public void setMonth(LocalDate month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "Budget{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", amount=" + amount +
                ", month=" + month +
                '}';
    }
}
