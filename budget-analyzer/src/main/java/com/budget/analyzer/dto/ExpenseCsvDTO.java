package com.budget.analyzer.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO for representing an Expense parsed from a CSV file.
 */
public class ExpenseCsvDTO {

    private String name;
    private BigDecimal amount;
    private String category;
    private LocalDate date;

    public ExpenseCsvDTO() {
    }

    public ExpenseCsvDTO(String name, BigDecimal amount, String category, LocalDate date) {
        this.name = name;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
