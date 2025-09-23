package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
    @Autowired 
    UserRepository userRepository;
    
    public User saveUser(User user){ 
    	return userRepository.save(user); 
    }
    
    public User getByEmail(String email){ 
    	return userRepository.findByEmail(email); 
    }
} 
