package com.budget.analyzer.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    // Expense type: BIG, MISC, SHORT
    @Column(nullable = false)
    private String type;

    // Main category (Food, Travel, Utilities, etc.)
    @Column(nullable = false)
    private String category;

    // Subcategory for misc/short expenses (Takeout, Luxury, etc.)
    private String subCategory;

    // Amount spent
    @Column(nullable = false)
    private BigDecimal amount;

    // Payment method (UPI, Cash, Card)
    private String paymentMethod;

    // Expense date
    @Column(nullable = false)
    private LocalDate expenseDate;

    // Optional: original CSV reference if uploaded
    private String csvReference;

    public Expense() {
    }

    public Expense(String type, String category, String subCategory, BigDecimal amount, String paymentMethod, LocalDate expenseDate, String csvReference) {
        this.type = type;
        this.category = category;
        this.subCategory = subCategory;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.expenseDate = expenseDate;
        this.csvReference = csvReference;
    }

    // ----- GETTERS & SETTERS -----

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getSubCategory() { return subCategory; }
    public void setSubCategory(String subCategory) { this.subCategory = subCategory; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public LocalDate getExpenseDate() { return expenseDate; }
    public void setExpenseDate(LocalDate expenseDate) { this.expenseDate = expenseDate; }

    public String getCsvReference() { return csvReference; }
    public void setCsvReference(String csvReference) { this.csvReference = csvReference; }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", category='" + category + '\'' +
                ", subCategory='" + subCategory + '\'' +
                ", amount=" + amount +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", expenseDate=" + expenseDate +
                ", csvReference='" + csvReference + '\'' +
                '}';
    }
}
