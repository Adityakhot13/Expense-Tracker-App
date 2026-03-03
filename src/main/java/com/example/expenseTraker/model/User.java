package com.example.expenseTraker.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true, nullable = false)
    @NonNull
    private String username;

    @Column(nullable = false)
    @NonNull
    @ToString.Exclude
    private String password; // Will store BCrypt hashed string

//    @Column(nullable = false)
    @NonNull
    private String email;

    // mappedBy points to the "user" field in the Expense class
    @ToString.Exclude
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Expense> expense = new ArrayList<>();

}
