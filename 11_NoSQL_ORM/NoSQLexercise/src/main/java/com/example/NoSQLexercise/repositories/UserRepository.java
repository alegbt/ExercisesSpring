package com.example.NoSQLexercise.repositories;

import com.example.NoSQLexercise.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
