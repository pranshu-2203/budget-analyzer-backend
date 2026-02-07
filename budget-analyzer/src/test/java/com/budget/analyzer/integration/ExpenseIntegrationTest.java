package com.budget.analyzer.integration;

import com.budget.analyzer.entity.Expense;
import com.budget.analyzer.repository.ExpenseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class ExpenseIntegrationTest {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Test
    void fullFlow_createAndCalculateTotal() {
        // unique category ONLY for this test
        String testCategory = "INTEGRATION_TEST_CATEGORY";

        Expense e1 = new Expense();
        e1.setName("Tea");
        e1.setType("EXPENSE");
        e1.setCategory(testCategory);
        e1.setSubCategory("Cafe");
        e1.setAmount(BigDecimal.valueOf(100));
        e1.setPaymentMethod("CASH");
        e1.setExpenseDate(LocalDate.now());

        Expense e2 = new Expense();
        e2.setName("Snacks");
        e2.setType("EXPENSE");
        e2.setCategory(testCategory);
        e2.setSubCategory("Shop");
        e2.setAmount(BigDecimal.valueOf(200));
        e2.setPaymentMethod("CASH");
        e2.setExpenseDate(LocalDate.now());

        expenseRepository.save(e1);
        expenseRepository.save(e2);

        double total = expenseRepository.findByCategory(testCategory)
                .stream()
                .map(e -> e.getAmount().doubleValue())
                .reduce(0.0, Double::sum);

        assertThat(total).isEqualTo(300.0);
    }
}
