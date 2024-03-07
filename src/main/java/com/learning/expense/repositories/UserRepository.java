package com.learning.expense.repositories;

import org.springframework.data.repository.CrudRepository;

import com.learning.expense.domain.User;

public interface UserRepository extends CrudRepository<User, String>{
    
}