package com.budget.analyzer.controller;

import com.budget.analyzer.entity.Expense;
import com.budget.analyzer.service.ExpenseService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    // Add a new expense
    @PostMapping
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense) {
        Expense savedExpense = expenseService.addExpense(expense);
        return ResponseEntity.ok(savedExpense);
    }

    // Get all expenses
    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses() {
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    // Get expense by ID
    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable Long id) {
        Optional<Expense> expense = expenseService.getExpenseById(id);
        return expense.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Delete an expense
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.noContent().build();
    }

    // Get expenses by type
    @GetMapping("/type/{type}")
    public ResponseEntity<List<Expense>> getExpensesByType(@PathVariable String type) {
        return ResponseEntity.ok(expenseService.getExpensesByType(type));
    }

    // Get expenses by category
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Expense>> getExpensesByCategory(@PathVariable String category) {
        return ResponseEntity.ok(expenseService.getExpensesByCategory(category));
    }

    // Get expenses by sub-category
    @GetMapping("/subcategory/{subCategory}")
    public ResponseEntity<List<Expense>> getExpensesBySubCategory(@PathVariable String subCategory) {
        return ResponseEntity.ok(expenseService.getExpensesBySubCategory(subCategory));
    }

    // Get expenses between dates
    @GetMapping("/between")
    public ResponseEntity<List<Expense>> getExpensesBetweenDates(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ResponseEntity.ok(expenseService.getExpensesBetweenDates(startDate, endDate));
    }

    // Get total expenses
    @GetMapping("/total")
    public ResponseEntity<Double> getTotalExpenses() {
        return ResponseEntity.ok(expenseService.getTotalExpenses());
    }

    // Get total expenses by type
    @GetMapping("/total/type/{type}")
    public ResponseEntity<Double> getTotalExpensesByType(@PathVariable String type) {
        return ResponseEntity.ok(expenseService.getTotalExpensesByType(type));
    }

    // Get total expenses by category
    @GetMapping("/total/category/{category}")
    public ResponseEntity<Double> getTotalExpensesByCategory(@PathVariable String category) {
        return ResponseEntity.ok(expenseService.getTotalExpensesByCategory(category));
    }

    // Get expenses by payment method
    @GetMapping("/payment/{method}")
    public ResponseEntity<List<Expense>> getExpensesByPaymentMethod(@PathVariable String method) {
        return ResponseEntity.ok(expenseService.getExpensesByPaymentMethod(method));
    }
}
