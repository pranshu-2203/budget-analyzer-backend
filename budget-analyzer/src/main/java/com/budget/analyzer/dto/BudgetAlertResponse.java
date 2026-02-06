package com.budget.analyzer.dto;

import java.time.LocalDate;

/**
 * DTO for sending budget alert responses to the client.
 */
public class BudgetAlertResponse {

    private String category;
    private double budgetAmount;
    private double spentAmount;
    private String alertMessage;
    private LocalDate month;

    public BudgetAlertResponse() {
    }

    public BudgetAlertResponse(String category, double budgetAmount, double spentAmount, String alertMessage, LocalDate month) {
        this.category = category;
        this.budgetAmount = budgetAmount;
        this.spentAmount = spentAmount;
        this.alertMessage = alertMessage;
        this.month = month;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getBudgetAmount() {
        return budgetAmount;
    }

    public void setBudgetAmount(double budgetAmount) {
        this.budgetAmount = budgetAmount;
    }

    public double getSpentAmount() {
        return spentAmount;
    }

    public void setSpentAmount(double spentAmount) {
        this.spentAmount = spentAmount;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    public LocalDate getMonth() {
        return month;
    }

    public void setMonth(LocalDate month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "BudgetAlertResponse{" +
                "category='" + category + '\'' +
                ", budgetAmount=" + budgetAmount +
                ", spentAmount=" + spentAmount +
                ", alertMessage='" + alertMessage + '\'' +
                ", month=" + month +
                '}';
    }
}
