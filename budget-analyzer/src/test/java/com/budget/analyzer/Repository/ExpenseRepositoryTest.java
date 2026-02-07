package com.budget.analyzer.Repository;

import com.budget.analyzer.entity.Expense;
import com.budget.analyzer.repository.ExpenseRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class ExpenseRepositoryTest {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Test
    void findByCategory_shouldReturnResults() {
        Expense expense = new Expense();
        expense.setName("Dinner");
        expense.setType("EXPENSE");
        expense.setCategory("Food");
        expense.setSubCategory("Hotel");
        expense.setAmount(BigDecimal.valueOf(500));
        expense.setPaymentMethod("CARD");
        expense.setExpenseDate(LocalDate.now());

        expenseRepository.save(expense);

        List<Expense> result = expenseRepository.findByCategory("Food");

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getName()).isEqualTo("Dinner");
    }
}
