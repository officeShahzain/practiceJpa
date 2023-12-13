package com.example.practiceJpa.repository;

import com.example.practiceJpa.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Integer> {

}
