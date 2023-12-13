package com.example.practiceJpa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @SequenceGenerator(name = "sequence_Id",
            sequenceName = "sequence_Id",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "sequence_Id")
    private int id;
    @Column(name = "student_name")
    private String studentName;
    private String password;
    private String token;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Course> course;
}
