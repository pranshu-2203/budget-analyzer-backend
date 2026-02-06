package com.budget.analyzer.repository;

import com.budget.analyzer.entity.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Repository interface for Budget entity.
 * Provides basic CRUD operations and custom query methods.
 */
@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {

    /**
     * Find all budgets for a given month.
     *
     * @param month the month to filter budgets
     * @return list of budgets for that month
     */
    List<Budget> findByMonth(LocalDate month);

    /**
     * Find budget by category and month.
     *
     * @param category the budget category
     * @param month    the month
     * @return budget for that category and month
     */
    Budget findByCategoryAndMonth(String category, LocalDate month);
}
