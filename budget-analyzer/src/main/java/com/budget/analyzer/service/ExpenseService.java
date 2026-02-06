package com.budget.analyzer.service;

import com.budget.analyzer.entity.Expense;
import com.budget.analyzer.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    // Add a new expense
    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    // Get all expenses
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    // Get expense by ID
    public Optional<Expense> getExpenseById(Long id) {
        return expenseRepository.findById(id);
    }

    // Delete expense by ID
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    // Get expenses by type (BIG, SHORT, MISC)
    public List<Expense> getExpensesByType(String type) {
        return expenseRepository.findByType(type);
    }

    // Get expenses by category
    public List<Expense> getExpensesByCategory(String category) {
        return expenseRepository.findByCategory(category);
    }

    // Get expenses by subCategory
    public List<Expense> getExpensesBySubCategory(String subCategory) {
        return expenseRepository.findBySubCategory(subCategory);
    }

    // Get expenses by date range
    public List<Expense> getExpensesBetweenDates(LocalDate startDate, LocalDate endDate) {
        return expenseRepository.findByExpenseDateBetween(startDate, endDate);
    }

    // Get expenses by type and category
    public List<Expense> getExpensesByTypeAndCategory(String type, String category) {
        return expenseRepository.findByTypeAndCategory(type, category);
    }

    // Get expenses by payment method (UPI, CASH, CARD)
    public List<Expense> getExpensesByPaymentMethod(String paymentMethod) {
        return expenseRepository.findByPaymentMethod(paymentMethod);
    }

    // Calculate total amount for all expenses
    public double getTotalExpenses() {
        return expenseRepository.findAll()
                .stream()
                .mapToDouble(expense -> expense.getAmount().doubleValue())
                .sum();
    }

    // Calculate total amount for a type
    public double getTotalExpensesByType(String type) {
        return expenseRepository.findByType(type)
                .stream()
                .mapToDouble(expense -> expense.getAmount().doubleValue())
                .sum();
    }

    // Calculate total amount for a category
    public double getTotalExpensesByCategory(String category) {
        return expenseRepository.findByCategory(category)
                .stream()
                .mapToDouble(expense -> expense.getAmount().doubleValue())
                .sum();
    }
}
