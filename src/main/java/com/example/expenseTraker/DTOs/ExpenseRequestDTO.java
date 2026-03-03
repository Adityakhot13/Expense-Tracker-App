package com.example.expenseTraker.DTOs;

import com.example.expenseTraker.model.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
//@Component
public class ExpenseRequestDTO {
    private Long id;
    private Double amount;
    private Category category;
    private LocalDate date;
    private String description;

    public ExpenseRequestDTO(Double amount, Category category, LocalDate expenseDate, String description) {
        this.amount = amount;
        this.category = category;
        this.date = expenseDate;
        this.description = description;
    }
    public ExpenseRequestDTO(Long id ,Double amount, Category category, LocalDate expenseDate, String description) {
        this.id=id;
        this.amount = amount;
        this.category = category;
        this.date = expenseDate;
        this.description = description;
    }

}
