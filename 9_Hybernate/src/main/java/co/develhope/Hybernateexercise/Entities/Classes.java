package co.develhope.Hybernateexercise.Entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "classes")
@Data
public class Classes {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IdClass;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;






}
