package com.example.GroupProject.Controller;

import com.example.GroupProject.Artifacts.Login;
import com.example.GroupProject.Entity.User;
import com.example.GroupProject.Repository.UserRepository;
import com.example.GroupProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/auth/")
public class UserController{
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody  User user){
        if(userRepository.existsByEmail(user.getEmail())){
            return ResponseEntity.status(HttpStatus.OK).body("Email have already used");
        }
        User userSaved = userService.createUser(user);
        if(userSaved != null){
            return ResponseEntity.status(HttpStatus.CREATED).body("Registration Successful");
        }
        return  ResponseEntity.status(HttpStatus.OK).body("User Creation Failed");
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Login login){
        if(userRepository.existsByEmail(login.getEmail())){
            User user = userService.getUserByEmail(login.getEmail());
            if(user.getPassword().equals(login.getPassword()) && user.getEmail().equals(login.getEmail())){
                return  ResponseEntity.status(HttpStatus.OK).body("Successfully Login");
            }else{
                return  ResponseEntity.status(HttpStatus.OK).body("Password is incorrect");
            }
        }else{
            return ResponseEntity.status(HttpStatus.OK).body("User not found for given email");
        }
    }
}
