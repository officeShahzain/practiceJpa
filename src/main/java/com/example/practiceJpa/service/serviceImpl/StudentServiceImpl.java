package com.example.practiceJpa.service.serviceImpl;

import com.example.practiceJpa.Mapper.Mapper;
import com.example.practiceJpa.entities.Course;
import com.example.practiceJpa.entities.Student;
import com.example.practiceJpa.payload.StudentDto;
import com.example.practiceJpa.repository.StudentRepo;
import com.example.practiceJpa.service.StudentService;
import jakarta.transaction.Transactional;
import org.apache.tomcat.util.bcel.classfile.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    private Mapper mapper;
    StudentRepo studentRepo;

    @Override
    public void create(StudentDto student) {
        boolean flag = save(student);
        if(flag == true)
        {
            System.out.println("Student Save Successfully!");
        }
        else {
            System.out.println("Something wrong!");
        }
    }

    @Override
    public void update(StudentDto student) {
        updateStudentRecord(student);
    }

    @Override
    public void deleteById(int studentId) {
          deleteStudent(studentId);
    }

    @Override
    public StudentDto getStudentById(int studentId) {
        Student student = getSpecificStudent(studentId);
        StudentDto studentDto = mapper.entityToStudentDto(student);
        return studentDto;
    }

    @Override
    public List<StudentDto> getAllStudent(int pageNo, int recordSize) {
        List<Student> studentEntity = getAllStudentWithPage(pageNo, recordSize);
           List<StudentDto> studentDto = mapper.entityListTotDtoList(studentEntity);
           return studentDto;
    }

    boolean save(StudentDto studentDto)
    {
        Student student = mapper.studentDtoToEntity(studentDto);
        student.setToken(UUID.randomUUID().toString());
        student.setCourse(new ArrayList<>());
        studentRepo.save(student);
        return true;
    }
    private StudentDto updateStudentRecord(StudentDto studentDto)
    {
        Student student = getSpecificStudent(studentDto.getId());
        student.setStudentName(studentDto.getName());
        student.setCourse((List<Course>) studentDto.getCourseDto());
        studentRepo.save(student);
        StudentDto updatedStudentDto = mapper.entityToStudentDto(student);

        return studentDto;
    }
   private Student getSpecificStudent(int studentId)
    {
        Student student = studentRepo.findById(studentId).orElseThrow(()-> new RuntimeException("User Not Found"));
        return student;
    }
    void deleteStudent(int studentId)
    {
        Student student = getSpecificStudent(studentId);
        studentRepo.delete(student);
    }
    List<Student> getAllStudentWithPage(int pageNo , int recordSize)
    {
        Pageable pageable = PageRequest.of(pageNo, recordSize);
        List<Student> students = studentRepo.findAll(pageable).getContent();
        long totalElement = studentRepo.findAll(pageable).getTotalElements();
        long totalPage = studentRepo.findAll(pageable).getTotalPages();
        return students;
    }
}
