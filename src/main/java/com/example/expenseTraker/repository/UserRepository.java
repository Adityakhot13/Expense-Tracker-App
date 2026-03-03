package com.example.expenseTraker.repository;

import com.example.expenseTraker.DTOs.getUserDTO;
import com.example.expenseTraker.model.Expense;
import com.example.expenseTraker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Used by Spring Security to find the user during login
    User findByUsername(String username);

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    @Query("""
SELECT new com.example.expenseTraker.DTOs.getUserDTO(e.userId,e.username,e.email)
FROM User e
WHERE e.email =:email
""")
    getUserDTO findByEmail(String email);
//    @Override
//    <S extends User> S saveAndFlush(S entity);

}