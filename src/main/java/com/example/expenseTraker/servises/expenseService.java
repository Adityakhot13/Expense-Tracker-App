package com.example.expenseTraker.servises;

import com.example.expenseTraker.DTOs.Category_SumDTO;
import com.example.expenseTraker.DTOs.ExpenseRequestDTO;
import com.example.expenseTraker.DTOs.ExpenseResponseDTO;
import com.example.expenseTraker.DTOs.MonthlyReportDTO;
import com.example.expenseTraker.model.Category;
import com.example.expenseTraker.model.Expense;
import com.example.expenseTraker.model.User;
import com.example.expenseTraker.repository.ExpenseRepository;
import com.example.expenseTraker.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class expenseService {
    private final UserRepository repo;
    private final ExpenseRepository expenseRepo;

    @Transactional
    public ResponseEntity<?> addExpense(ExpenseRequestDTO request ,String userName){
        User user = repo.findByUsername(userName);
        Expense e = new Expense(request,user);
        expenseRepo.save(e);
        List<Expense> list = user.getExpense();
        list.add(e);

        return ResponseEntity.status(HttpStatus.OK).body("Expense saved successfully!");
    }

    @Transactional
    public ResponseEntity<?> getExpensesByUser(String userName){

        User user = repo.findByUsername(userName);

        if(user == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No User Found!");
        }

        List<ExpenseResponseDTO> expenses =
                expenseRepo.findByUser_UserId(user.getUserId());

        return ResponseEntity.ok(expenses);
    }

    @Transactional
    public ResponseEntity<?> getTop3ExpensesByUser(String userName){

        User user = repo.findByUsername(userName);

        if(user == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No User Found!");
        }

        List<ExpenseResponseDTO> expenses =
                expenseRepo.findTop3ByUser_UserIdOrderByAmountDesc(user.getUserId());

        return ResponseEntity.ok(expenses);
    }

    public MonthlyReportDTO getReport(String username, int Month){
        User user = repo.findByUsername(username);


        MonthlyReportDTO m = new MonthlyReportDTO();
        m.Month=Month;
        m.Year=2026;
//        total spending
        Long Sum = expenseRepo.findSum(user.getUserId(),Month);
        m.TotalSpedndedAmmount=Sum;

        List<ExpenseResponseDTO> Top3 =
                expenseRepo.findTop3ByUser_UserIdOrderByAmountDesc(user.getUserId());
        m.HighestAmmount=Top3;

        List<Category_SumDTO> Categorywise =expenseRepo.findCategoryWiseTotal(user.getUserId(),Month);
        m.CategoryWiseExpenses .add(Categorywise) ;

        m.NoOfTransactions =expenseRepo.countExpense(user.getUserId(),Month);
        return m;
    }
}
