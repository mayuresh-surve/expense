package com.learning.expense.services;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.learning.expense.domain.Expense;
import com.learning.expense.domain.Group;
import com.learning.expense.domain.User;
import com.learning.expense.domain.UserExpense;
import com.learning.expense.dto.ExpenseRequest;
import com.learning.expense.repositories.ExpenseRepository;
import com.learning.expense.repositories.GroupRepository;
import com.learning.expense.repositories.UserExpenseRepository;
import com.learning.expense.repositories.UserRepository;

@Service
public class ExpenseService {

    private ExpenseRepository expenseRepository;
    private UserExpenseRepository userExpenseRepository;
    private GroupRepository groupRepository;
    private UserRepository userRepository;

    public ExpenseService(ExpenseRepository expenseRepository, UserExpenseRepository userExpenseRepository,
            GroupRepository groupRepository, UserRepository userRepository) {
        this.expenseRepository = expenseRepository;
        this.userExpenseRepository = userExpenseRepository;
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
    }

    // Adding Expense and UserExpense to the database
    @SuppressWarnings("null")
    public void addExpense(ExpenseRequest expenseRequest) throws Exception {
        Expense expense = new Expense();
        expense.setDescription(expenseRequest.getDescription());
        expense.setAmount(expenseRequest.getAmount());
        expense.setSplitType(expenseRequest.getSplitType());
        Expense savedExpense = expenseRepository.save(expense);

        Map<String, BigDecimal> payer = expenseRequest.getPayer();
        Map<String, BigDecimal> participants = expenseRequest.getParticipants();

        if (participants != null && payer != null) {
            participants.forEach((userId, amount) -> {
                User user = userRepository.findById(userId).orElseThrow();
                UserExpense userExpense = createUserExpense(savedExpense, amount, payer.get(userId), user);
                userExpenseRepository.save(userExpense);
            });
        }
    }

    // Build UserExpense object for each participant and payer
    @SuppressWarnings("null")
    private UserExpense createUserExpense(Expense expense, BigDecimal amountOwed, BigDecimal amountPaid, User user) {
        UserExpense userExpense = new UserExpense();
        userExpense.setAmountOwed(amountOwed != null ? amountOwed : BigDecimal.ZERO);
        userExpense.setAmountPaid(amountPaid != null ? amountPaid : BigDecimal.ZERO);
        userExpense.setExpense(expense);
        userExpense.setUser(user);

        if (expense.getGroupId() != null) {
            Group group = groupRepository.findById(expense.getGroupId()).orElseThrow();
            userExpense.setGroup(group);
        }

        return userExpense;
    }

    public void updateExpenseAmount(String id, BigDecimal newAmount) {
        expenseRepository.updateExpenseAmount(id, newAmount);
    }

    @SuppressWarnings("null")
    public void addExpensePartcipants(Expense expense, Set<UserExpense> participants) {
        participants.forEach((userExpense) -> {
            expense.getParticipants().add(userExpense);
        });
        expenseRepository.save(expense);
    }
}
