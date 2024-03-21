package com.learning.expense.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learning.expense.domain.Group;

@Repository
public interface GroupRepository extends CrudRepository<Group, String>{

}
