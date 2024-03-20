package com.learning.expense.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learning.expense.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{
    
}