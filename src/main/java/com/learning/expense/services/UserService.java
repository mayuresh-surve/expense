package com.learning.expense.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.learning.expense.domain.User;
import com.learning.expense.repositories.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @SuppressWarnings("null")
    public User getUserById(String id){
        Optional<User> userResult = userRepository.findById(id);
        if(userResult.isPresent()) {
            System.out.println("User found");
            return userResult.get();
        } else {
            System.out.println("User not found");
            return null;
        }
    }
    
    @SuppressWarnings("null")
    public User create(User user){
        return userRepository.save(user);
    }

    @SuppressWarnings("null")
    public User update(User user){
        return userRepository.save(user);
    }

    @SuppressWarnings("null")
    public void deleteById(String id) throws Exception {
        if(!userRepository.existsById(id)){
            throw new Exception("Id does not exists");
        }
        userRepository.deleteById(id);
    }
}