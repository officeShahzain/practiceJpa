package com.example.practiceJpa.service;

import com.example.practiceJpa.entities.Student;
import com.example.practiceJpa.payload.StudentDto;
import org.apache.catalina.User;

import java.util.List;

public interface StudentService {

    void create(StudentDto student);
    void update(StudentDto student);
    void deleteById(int studentId);
    StudentDto getStudentById(int studentId);

    List<StudentDto> getAllStudent(int pageNo, int recordSize);

}
