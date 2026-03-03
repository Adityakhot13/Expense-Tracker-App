package com.example.expenseTraker.DTOs;

import com.example.expenseTraker.model.Expense;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class MonthlyReportDTO {
    public int Month;
    public int Year;
    public Long TotalSpedndedAmmount;
    public List<ExpenseResponseDTO> HighestAmmount;
    public List<List<Category_SumDTO>> CategoryWiseExpenses = new ArrayList<>();
    public int NoOfTransactions ;
}
