package com.example.expenseTraker.servises;


import com.example.expenseTraker.DTOs.*;
import com.example.expenseTraker.model.Category;
import com.example.expenseTraker.model.Expense;
import com.example.expenseTraker.model.User;
import com.example.expenseTraker.repository.ExpenseRepository;
import com.example.expenseTraker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class userServise {

    private final UserRepository repo;
    private final ExpenseRepository expenseRepo;

    public userServise(UserRepository repo,ExpenseRepository expenseRepo){
        this.repo=repo;
        this.expenseRepo=expenseRepo;
    }


    public ResponseEntity<String> resisterUser(userRequestDTO req){

           if(repo.existsByEmail(req.getEmail())){
               return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("User Exist!");
           }
           else {
               User u = new User(req.getUsername(),req.getPassword(),req.getEmail());
               repo.save(u);
               return ResponseEntity.status(HttpStatus.OK).body("User Created!");

           }
    }

    public ResponseEntity<String> loginUser(userRequestDTO req) {

        if (repo.existsByUsername(req.getUsername())) {
            User u = repo.findByUsername(req.getUsername());
            if (u.getPassword().equals(req.getPassword())) {
                return ResponseEntity.status(HttpStatus.OK).body("Login Successful !");
            }

        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Invalid Username Or Password !");
    }

    public ResponseEntity<String> deleteUser(userRequestDTO req) {

        if (repo.existsByEmail(req.getEmail())) {
            User u = repo.findByUsername(req.getUsername());
            if (u.getPassword().equals(req.getPassword())) {
                repo.deleteById(u.getUserId());
                return ResponseEntity.status(HttpStatus.OK).body("Deleted Successful !");
            }

        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Invalid User!");
    }



//    public Expense addExpense(AddExpenseDTO request , String userName){
//
//        User u = repo.findByUsername(userName);
//        Expense e = new Expense() ;
//        u.getExpense().add(e);
//        e.setUser(u);
//        e.setAmount(request.getAmount());
//        e.setCategory(request.getCategory());
//        e.setDescription(request.getDescription());
//        e.setDate();
//        return expenseRepo.save(e);
//    }
//    public List<ExpenseSummaryDTO> getExpense (String uName){
//
//        User u = repo.findByUsername(uName);
//        List<ExpenseSummaryDTO> E = expenseRepo.findExpenseSummaryByUserId(u.getUserId());
//
//        return E;
//    }
//    public boolean CreateUser(){
//
//        User u1 = new User("Aditya13","Aditya13","adikhot007@gmail.com");
//        Expense e1 = new Expense("For Coffie",100.0, Category.FOOD_AND_DRINK,u1);
//        u1.getExpense().add(e1);
//        Expense e2 = new Expense("For Dinner",250.0, Category.FOOD_AND_DRINK,u1);
//        u1.getExpense().add(e2);
//        Expense e3 = new Expense("for tour",2500.0, Category.TRANSPORTATION,u1);
//        u1.getExpense().add(e3);
//        Expense e4 = new Expense("for trip",5000.0, Category.TRANSPORTATION,u1);
//        u1.getExpense().add(e4);
//        Expense e5 = new Expense("for hospital bill",120.0, Category.HEALTH_AND_MEDICAL,u1);
//        Expense e6 = new Expense("for medical bill",150.0, Category.HEALTH_AND_MEDICAL,u1);
////        String description, Double amount, Category, User)
//        repo.save(u1);
//        expenseRepo.save(e1);
//        expenseRepo.save(e2);
//        expenseRepo.save(e3);
//        expenseRepo.save(e4);
//        expenseRepo.save(e5);
//        expenseRepo.save(e6);
//
//        return true;
//    }
//
//    public getUserDTO ByEmail(String email){
//        return repo.findByEmail(email);
//
//    }


}
