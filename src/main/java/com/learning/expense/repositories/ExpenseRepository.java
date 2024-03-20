package com.learning.expense.repositories;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learning.expense.domain.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, String> {

    // Update expense amount method
    @SuppressWarnings("null")
    default void updateExpenseAmount(String id, BigDecimal newAmount) {
        findById(id).ifPresent(expense -> {
            expense.setAmount(newAmount);
            save(expense);
        });
    }
}
