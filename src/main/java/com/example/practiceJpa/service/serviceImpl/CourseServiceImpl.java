package com.example.practiceJpa.service.serviceImpl;

import com.example.practiceJpa.Mapper.Mapper;
import com.example.practiceJpa.entities.Course;
import com.example.practiceJpa.payload.CourseDto;
import com.example.practiceJpa.repository.CourseRepo;
import com.example.practiceJpa.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;
    private Mapper mapper;
    @Override
    public void create(CourseDto courseDto) {
        try {
            saveCourse(courseDto);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void update(CourseDto courseDto) {

        try {
            updateCourse(courseDto);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int courseId) {
        try {
            deleteCourse(courseId);
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public CourseDto getCourseWithId(int courseId) {
        Course course = getSpecificCourse(courseId);
        CourseDto courseDto = mapper.entityToCourseDto(course);
        return courseDto;
    }

    @Override
    public List<CourseDto> getCourseWithPageable(int pageNo, int recordSize) {
        List<CourseDto> courseDtoList = courseDtoListPage(pageNo, recordSize);
        return courseDtoList;
    }

    private void saveCourse(CourseDto courseDto)
    {
        Course course = mapper.courseDtoToEntity(courseDto);
        courseRepo.save(course);
    }

    private void updateCourse(CourseDto courseDto)
    {
        Course course = mapper.courseDtoToEntity(courseDto);
        course.setCourseName(courseDto.getCourseTitle());
        course.setCreditHour(course.getCreditHour());
        courseRepo.save(course);
    }
    private Course getSpecificCourse(int courseId)
    {
        Course course = courseRepo.findById(courseId).orElseThrow(()-> new RuntimeException("Course Not Found"));
        return course;
    }
    private void deleteCourse(int courseId)
    {
        Course course = getSpecificCourse(courseId);
        courseRepo.delete(course);
    }
    private  List<CourseDto> courseDtoListPage(int pageNo, int recordSize)
    {
        Pageable pageable = PageRequest.of(pageNo, recordSize);
        List<Course> courseList = courseRepo.findAll(pageable).getContent();
        List<CourseDto> courseDtoList = mapper.entityListToCourseDtoList(courseList);
        return courseDtoList;
    }
}
