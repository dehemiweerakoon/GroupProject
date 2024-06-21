package com.example.GroupProject.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private  String name;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(nullable = false,unique = true)
    private String contactNo;

    @Column(nullable = false,unique = true)
    private String password;
}
