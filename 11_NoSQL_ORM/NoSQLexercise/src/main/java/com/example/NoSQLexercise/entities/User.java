package com.example.NoSQLexercise.entities;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
public class User {


    @Id
    private String id;

    private String name;
    private String surname;
    @Indexed(unique = true)
    private String email;



}
