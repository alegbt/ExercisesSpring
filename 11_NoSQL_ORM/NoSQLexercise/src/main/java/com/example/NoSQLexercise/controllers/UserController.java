package com.example.NoSQLexercise.controllers;

import com.example.NoSQLexercise.entities.User;
import com.example.NoSQLexercise.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;


    @PostMapping("/create")
    public User create(@RequestBody User user){
        //user.setId(null);
        return userRepository.save(user);
    }

    @GetMapping("/getall")
    public List<User> getall(){
        return userRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public User getSingle(@PathVariable String id) throws Exception{
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }else{
            throw new Exception("user not found");
        }
    }

    @PutMapping("/update/{id}")
    public User update(@PathVariable String id, @RequestBody User user) throws Exception{
        if(!userRepository.existsById(id)){
            throw new Exception("user id not found");
        }
        user.setId(id);
        return userRepository.save(user);
    }



    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable String id){
        userRepository.deleteById(id);
    }



}
