package com.example.practiceJpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @SequenceGenerator(name = "courseId",
    sequenceName = "courseId",
    allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "courseId")
    private int id;
    private String courseName;
    private int creditHour;
    @ManyToOne
    //@JoinColumn(name = "student_id")
    private Student student;
}
