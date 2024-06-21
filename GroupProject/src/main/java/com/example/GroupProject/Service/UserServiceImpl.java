package com.example.GroupProject.Service;

import com.example.GroupProject.Entity.User;
import com.example.GroupProject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByemail(email).orElse(null);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
