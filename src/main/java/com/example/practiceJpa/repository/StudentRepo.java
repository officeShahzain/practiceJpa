package com.example.practiceJpa.repository;

import com.example.practiceJpa.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepo extends JpaRepository<Student, Integer> {
    @Query("select s from Student s where s.studentName =: studentname")
    Student getStudentByName(String studentname);
}
