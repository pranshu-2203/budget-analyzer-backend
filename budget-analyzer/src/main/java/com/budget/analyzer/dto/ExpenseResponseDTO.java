package com.budget.analyzer.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO for sending Expense data in API responses.
 */
public class ExpenseResponseDTO {

    private Long id;
    private String name;
    private BigDecimal amount;
    private String category;
    private LocalDate date;
    private String subCategory;
    private String type;
    private String paymentMethod;
    private LocalDate expenseDate;



    public ExpenseResponseDTO() {
    }

    public ExpenseResponseDTO(Long id, String name, BigDecimal amount, String category, LocalDate date) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }
    public String getSubCategory() {
        return subCategory;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
