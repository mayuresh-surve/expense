package com.learning.expense.services;

import org.springframework.stereotype.Service;

import com.learning.expense.repositories.GroupRepository;

@Service
public class GroupService {

    private GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository){
        this.groupRepository = groupRepository;
    }
}
