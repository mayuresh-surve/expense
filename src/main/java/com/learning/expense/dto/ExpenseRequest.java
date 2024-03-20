package com.learning.expense.dto;

import java.math.BigDecimal;
import java.util.HashMap;

import com.learning.expense.domain.Expense;

import lombok.Data;

@Data
public class ExpenseRequest {

    private Expense expense;
    private HashMap<Long, BigDecimal> participants;
}
