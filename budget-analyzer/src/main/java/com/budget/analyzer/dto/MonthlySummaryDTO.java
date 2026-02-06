package com.budget.analyzer.dto;

import java.math.BigDecimal;
import java.util.Map;

/**
 * DTO for monthly summary data transfer.
 * Can be used internally or for API responses.
 */
public class MonthlySummaryDTO {

    private String month; // e.g., "January 2026"
    private BigDecimal totalBudget;
    private BigDecimal totalExpenses;
    private BigDecimal totalSavings;
    private Map<String, BigDecimal> categoryWiseExpenses;

    public MonthlySummaryDTO() {
    }

    public MonthlySummaryDTO(String month, BigDecimal totalBudget, BigDecimal totalExpenses,
            BigDecimal totalSavings, Map<String, BigDecimal> categoryWiseExpenses) {
        this.month = month;
        this.totalBudget = totalBudget;
        this.totalExpenses = totalExpenses;
        this.totalSavings = totalSavings;
        this.categoryWiseExpenses = categoryWiseExpenses;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public BigDecimal getTotalBudget() {
        return totalBudget;
    }

    public void setTotalBudget(BigDecimal totalBudget) {
        this.totalBudget = totalBudget;
    }

    public BigDecimal getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(BigDecimal totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public BigDecimal getTotalSavings() {
        return totalSavings;
    }

    public void setTotalSavings(BigDecimal totalSavings) {
        this.totalSavings = totalSavings;
    }

    public Map<String, BigDecimal> getCategoryWiseExpenses() {
        return categoryWiseExpenses;
    }

    public void setCategoryWiseExpenses(Map<String, BigDecimal> categoryWiseExpenses) {
        this.categoryWiseExpenses = categoryWiseExpenses;
    }
}
