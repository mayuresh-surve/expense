package com.learning.expense.repositories;

import org.springframework.data.repository.CrudRepository;

import com.learning.expense.domain.UserExpense;

public interface UserExpenseRepository extends CrudRepository<UserExpense, String>{

}
