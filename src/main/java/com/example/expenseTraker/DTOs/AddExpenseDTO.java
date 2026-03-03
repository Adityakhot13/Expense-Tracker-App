package com.example.expenseTraker.DTOs;

import com.example.expenseTraker.model.Category;

public class AddExpenseDTO {

   public String description;
   public Double amount;
   public Category category;

    public AddExpenseDTO(String description, Double amount, Category category) {
        this.description = description;
        this.amount = amount;
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
