package com.learning.expense.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.expense.dto.ExpenseRequest;
import com.learning.expense.services.ExpenseService;


@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    
    private ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> addExpense(@RequestBody ExpenseRequest expenseRequest){
        expenseService.addExpense(expenseRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}