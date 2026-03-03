package com.example.expenseTraker.controller;


import com.example.expenseTraker.DTOs.ExpenseRequestDTO;
import com.example.expenseTraker.DTOs.MonthlyReportDTO;
import com.example.expenseTraker.DTOs.userRequestDTO;
import com.example.expenseTraker.servises.expenseService;
import com.example.expenseTraker.servises.userServise;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
//@RequiredArgsConstructor
public class homeController {


    private final userServise user_service;
    private final expenseService expense_service;

    public homeController(userServise user_service, expenseService expense_service) {
        this.user_service = user_service;
        this.expense_service = expense_service;
    }

    @PostMapping("/register")
    public ResponseEntity<String> resisterUser(@RequestBody userRequestDTO req){
       return user_service.resisterUser(req);

    }

    @PostMapping("/login")
    public ResponseEntity<String> LoginUser(@RequestBody userRequestDTO req){
        return user_service.loginUser(req);
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestBody userRequestDTO req){
        return user_service.deleteUser(req);

    }

    @PostMapping("/{userName}/add")
    public ResponseEntity<?> addExpense(@RequestBody ExpenseRequestDTO reqest ,@PathVariable String userName){

        return expense_service.addExpense(reqest,userName);
    }

    @GetMapping("/{userName}/get")
    public ResponseEntity<?> getExpense(@PathVariable String userName){

        return expense_service.getExpensesByUser(userName);
    }
    @GetMapping("/{userName}/get/top3")
    public ResponseEntity<?> getTop3Expense(@PathVariable String userName){

        return expense_service.getTop3ExpensesByUser(userName);
    }
    @GetMapping("/{userName}/report/{Month}")
    public MonthlyReportDTO getReport(@PathVariable String userName,@PathVariable int Month){

        return expense_service.getReport(userName,Month);
    }
//    @GetMapping("/get")
//    public String create(){
//
//        if(service.CreateUser()){
//            return "created";
//        }
//        return "Failed";
//    }
//    @GetMapping("/{uName}/expense")
//    public ResponseEntity<List<ExpenseSummaryDTO>> getExpense(@PathVariable String uName){
//
//
//        //        uName ="Aditya13";
//        List<ExpenseSummaryDTO> E = service.getExpense(uName);
//        for(ExpenseSummaryDTO e1 : E){
//            System.out.println(e1);
//        }
//        return  ResponseEntity.status(HttpStatus.OK).body(E);
//    }
//
//    @PostMapping("/{uName}/add")
//    public ResponseEntity<String> add(@RequestBody AddExpenseDTO request , @PathVariable String uName){
//
//      Expense e = service.addExpense(request,uName);
//       return ResponseEntity.status(HttpStatus.OK).body(e.toString()+" Added Successfully !");
//    }
//
//    @GetMapping("/ByEmail/{email}")
//    public ResponseEntity<getUserDTO> getUserByEmail(@PathVariable String email){
//        getUserDTO u1 =  service.ByEmail(email);
//       return ResponseEntity.status(HttpStatus.OK).body(u1);
//    }
}
