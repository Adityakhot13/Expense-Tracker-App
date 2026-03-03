package com.example.expenseTraker.repository;

import com.example.expenseTraker.DTOs.Category_SumDTO;
import com.example.expenseTraker.DTOs.ExpenseRequestDTO;
import com.example.expenseTraker.DTOs.ExpenseResponseDTO;
import com.example.expenseTraker.model.Category;
import com.example.expenseTraker.model.Expense;
import com.example.expenseTraker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    // Spring automatically writes the SQL: SELECT * FROM expenses WHERE user_id = ?
    List<ExpenseResponseDTO> findByUser(User user);

    // SQL: SELECT * FROM expenses WHERE category = ? AND user_id = ?
    List<Expense> findByCategoryAndUser(Category category, User user);

    // SQL: SELECT * FROM expenses WHERE amount > ?
    List<Expense> findByAmountGreaterThan(Double amount);

//    @Query("""
//    SELECT new com.example.expenseTraker.DTOs.ExpenseRequestDTO(
//        e.ide.amount, e.category, e.date,e.description
//    )
//    FROM Expense e
//    WHERE e.user.userId = :userId
//""")
    List<ExpenseRequestDTO> findExpenseByUser(Long userId);

    List<ExpenseResponseDTO> findByUser_UserId(Long userId);

    List<ExpenseResponseDTO> findTop3ByUser_UserIdOrderByAmountDesc(Long userId);

    @Query("""
    SELECT SUM(e.amount) from Expense e where e.user.id =:userId AND Month(e.date)=:month
""")
    Long findSum(@Param("userId")Long userId,@Param("month")int month);

    @Query("""
    SELECT COUNT(e.id) from Expense e where e.user.id =:userId AND Month(e.date)=:month
""")
    int countExpense(@Param("userId")Long userId,@Param("month")int month);

//    @Query("""
//    SELECT e.category as c, Sum(e.amount) as total
//             from Expense e where e.user.id =:userId
//             Group By e.category
//""")
@Query("""
       SELECT e.category as category,
              SUM(e.amount) as total
       FROM Expense e
       WHERE e.user.id = :userId And Month(e.date)=:Month
       GROUP BY e.category
       """)
    List<Category_SumDTO> findCategoryWiseTotal(Long userId,int Month);
}