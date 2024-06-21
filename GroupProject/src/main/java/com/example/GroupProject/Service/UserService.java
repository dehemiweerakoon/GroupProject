package com.example.GroupProject.Service;

import com.example.GroupProject.Entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

     User getUserByEmail(String email);
     User createUser(User user);
}
