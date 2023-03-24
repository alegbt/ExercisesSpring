package co.develhope.mockdb.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;



}
//creates a table Student with:
//a primary key
//a firstName
//a lastName
//a unique email
//use the h2-console with your browser and connect to the db
//you should see something like the h2-pic.PNG (you may find it in the folder) in the browser