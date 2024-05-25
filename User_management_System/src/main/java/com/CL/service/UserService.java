package com.CL.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CL.entity.User;
import com.CL.exception.InvalidUserDataException;
import com.CL.exception.UserNotFoundException;
import com.CL.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

    public User createUser(User user) {
        if (user==null) {
            throw new InvalidUserDataException("Invalid user data");
        }
        return userRepository.save(user);
    }

}






