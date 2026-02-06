package com.budget.analyzer.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO for creating or updating an Expense.
 */
public class ExpenseRequestDTO {

    private String name;
    private BigDecimal amount;
    private String category;
    private LocalDate date;
    private LocalDate expenseDate;
    public ExpenseRequestDTO() {
    }

    // ExpenseRequestDTO.java
    private String type;

    public String getType() {
        return type;
    }
    private String subCategory;

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    private String paymentMethod;

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDate getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ExpenseRequestDTO(String name, BigDecimal amount, String category, LocalDate date) {
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
