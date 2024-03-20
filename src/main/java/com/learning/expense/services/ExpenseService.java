package com.learning.expense.services;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.learning.expense.domain.Expense;
import com.learning.expense.dto.ExpenseRequest;
import com.learning.expense.repositories.ExpenseRepository;

@Service
public class ExpenseService {
    
    private ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

    @SuppressWarnings("null")
    public void addExpense(ExpenseRequest expenseRequest) {
        Expense expense = expenseRequest.getExpense();
        HashMap<Long, BigDecimal> participants = expenseRequest.getParticipants();
        expenseRepository.save(expense);
    }

    public void updateExpenseAmount(String id, BigDecimal newAmount){
        expenseRepository.updateExpenseAmount(id, newAmount);
    }
}
