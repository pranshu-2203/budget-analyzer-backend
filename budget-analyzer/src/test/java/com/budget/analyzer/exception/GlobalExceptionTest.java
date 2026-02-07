package com.budget.analyzer.exception;

import com.budget.analyzer.controller.ExpenseController;
import com.budget.analyzer.service.ExpenseService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = ExpenseController.class)
class GlobalExceptionHandlerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExpenseService expenseService;

    @Test
    void shouldReturn404WhenExpenseNotFound() throws Exception {
        // mock service behavior
        Mockito.when(expenseService.getExpenseById(999L))
                .thenThrow(new ResourceNotFoundException("Expense not found with id 999"));

        mockMvc.perform(get("/api/expenses/999")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Expense not found with id 999"));
    }
}
