package com.example.expenseTraker.DTOs;

import com.example.expenseTraker.model.Category;
import com.example.expenseTraker.model.Expense;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

//@Component
public interface ExpenseResponseDTO {
    Long getId();
    Double getAmount();
    String getCategory();
    String getDescription();
    LocalDate getDate();
}
