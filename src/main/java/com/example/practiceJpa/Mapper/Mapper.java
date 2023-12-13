package com.example.practiceJpa.Mapper;

import com.example.practiceJpa.entities.Course;
import com.example.practiceJpa.entities.Student;
import com.example.practiceJpa.payload.CourseDto;
import com.example.practiceJpa.payload.StudentDto;
import org.mapstruct.Mapping;

import javax.sound.midi.Soundbank;
import javax.xml.transform.Source;
import java.util.List;

@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {

    @Mapping(source = "name", target = "studentName")
    Student studentDtoToEntity(StudentDto studentDto);

    //@Mapping(source = "studentName", target = "name")
    List<StudentDto> entityListTotDtoList(List<Student> students);

    @Mapping(source = "studentName", target = "name")
    StudentDto entityToStudentDto(Student student);

    //CourseMapper
    @Mapping(source = "courseName", target = "courseTitle" )
    CourseDto entityToCourseDto(Course course);
    @Mapping(source = "courseTitle", target = "courseName")
    Course courseDtoToEntity(CourseDto course);
    @Mapping(source = "courseName", target = "courseTitle" )
    List<CourseDto> entityListToCourseDtoList (List<Course> courseList);





}
