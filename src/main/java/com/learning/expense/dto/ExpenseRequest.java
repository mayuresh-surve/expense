package com.learning.expense.dto;

import java.math.BigDecimal;
import java.util.Map;

import com.learning.expense.domain.SplitType;

import lombok.Data;

@Data
public class ExpenseRequest {

    private String description;
    private BigDecimal amount;
    private SplitType splitType;
    private Map<String, BigDecimal> payer;
    private Map<String, BigDecimal> participants;
}
