package co.develhope.Hybernateexercise.Entities;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private int IdStud;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false, unique = true)
    private String email;



    @ManyToMany
    @JoinTable(
     name = "enrollments",
     joinColumns = @JoinColumn(name = "IdStud"),
     inverseJoinColumns = @JoinColumn(name = "IdClass")
    )
    private List<Classes>classes;



}
