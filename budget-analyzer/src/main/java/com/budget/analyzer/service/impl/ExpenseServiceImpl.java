package com.budget.analyzer.service.impl;

import com.budget.analyzer.dto.ExpenseRequestDTO;
import com.budget.analyzer.dto.ExpenseResponseDTO;
import com.budget.analyzer.entity.Expense;
import com.budget.analyzer.exception.ResourceNotFoundException;
import com.budget.analyzer.service.ExpenseService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl {

    private final ExpenseService expenseService;

    
    public ExpenseServiceImpl(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    public ExpenseResponseDTO addExpense(ExpenseRequestDTO request) {
        Expense expense = new Expense();
        expense.setName(request.getName());
        expense.setAmount(request.getAmount());
        expense.setCategory(request.getCategory());
        expense.setType(request.getType());
        expense.setSubCategory(request.getSubCategory());
        expense.setPaymentMethod(request.getPaymentMethod());
        expense.setExpenseDate(request.getExpenseDate() != null ? request.getExpenseDate() : LocalDate.now());

        Expense savedExpense = expenseService.addExpense(expense);
        return mapToDTO(savedExpense);
    }

    public List<ExpenseResponseDTO> getAllExpenses() {
        return expenseService.getAllExpenses()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public ExpenseResponseDTO getExpenseById(Long id) {
        Expense expense = expenseService.getExpenseById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found with id: " + id));
        return mapToDTO(expense);
    }

    public ExpenseResponseDTO updateExpense(Long id, ExpenseRequestDTO request) {
        Expense expense = expenseService.getExpenseById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found with id: " + id));

        expense.setName(request.getName());
        expense.setAmount(request.getAmount());
        expense.setCategory(request.getCategory());
        expense.setType(request.getType());
        expense.setSubCategory(request.getSubCategory());
        expense.setPaymentMethod(request.getPaymentMethod());
        expense.setExpenseDate(request.getExpenseDate() != null ? request.getExpenseDate() : expense.getExpenseDate());

        Expense updatedExpense = expenseService.addExpense(expense);
        return mapToDTO(updatedExpense);
    }

    public void deleteExpense(Long id) {
        Expense expense = expenseService.getExpenseById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found with id: " + id));
        expenseService.deleteExpense(expense.getId());
    }

    private ExpenseResponseDTO mapToDTO(Expense expense) {
        ExpenseResponseDTO dto = new ExpenseResponseDTO();
        dto.setId(expense.getId());
        dto.setName(expense.getName());
        dto.setAmount(expense.getAmount());
        dto.setCategory(expense.getCategory());
        dto.setType(expense.getType());
        dto.setSubCategory(expense.getSubCategory());
        dto.setPaymentMethod(expense.getPaymentMethod());
        dto.setExpenseDate(expense.getExpenseDate());
        return dto;
    }
}
