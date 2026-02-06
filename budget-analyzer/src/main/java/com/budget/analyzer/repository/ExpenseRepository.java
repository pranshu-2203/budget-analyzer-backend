package com.budget.analyzer.repository;

import com.budget.analyzer.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    // Find all expenses of a certain type (BIG, SHORT, MISC)
    List<Expense> findByType(String type);

    // Find all expenses by category
    List<Expense> findByCategory(String category);

    // Find all expenses by subCategory
    List<Expense> findBySubCategory(String subCategory);

    // Find all expenses in a date range
    List<Expense> findByExpenseDateBetween(LocalDate startDate, LocalDate endDate);

    // Find by type and category
    List<Expense> findByTypeAndCategory(String type, String category);

    // Find all expenses by payment method
    List<Expense> findByPaymentMethod(String paymentMethod);
}
