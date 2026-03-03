package com.example.expenseTraker.model;

import com.example.expenseTraker.DTOs.ExpenseRequestDTO;
import jakarta.persistence.*;
import lombok.*;

//import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "UserExpenses")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double amount;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    private boolean isAiGenerated = false;

    public Expense( String description, Double amount, Category category,User user) {

        this.description = description;
        this.amount = amount;
        this.date = LocalDate.now();
        this.category = category;

    }

    public Expense(String description, Double amount, LocalDate date, Category category,User user) {

        this.description = description;
        this.amount = amount;
        this.date = LocalDate.now();
        this.category = category;
        this.user = user;
    }
    public Expense(ExpenseRequestDTO request,User user){
        this.description=request.getDescription();
        this.amount= request.getAmount();
        this.date=request.getDate();
        this.category=request.getCategory();
        this.user=user;
    }


}
