package com.budget.analyzer.service;

import com.budget.analyzer.entity.Expense;
import com.budget.analyzer.repository.ExpenseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class ExpenseServiceTest {

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private ExpenseRepository expenseRepository;

    @Test
    void shouldReturnAllExpenses() {
        Expense expense = new Expense();
        expense.setName("Groceries");
        expense.setType("EXPENSE");
        expense.setCategory("Food");
        expense.setSubCategory("Daily");
        expense.setAmount(BigDecimal.valueOf(300));
        expense.setPaymentMethod("CASH");
        expense.setExpenseDate(LocalDate.now());

        expenseRepository.save(expense);

        List<Expense> expenses = expenseService.getAllExpenses();

        assertThat(expenses).isNotEmpty();
        assertThat(expenses.get(0).getCategory()).isEqualTo("Food");
    }
}
