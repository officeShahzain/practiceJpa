package com.example.practiceJpa.service;

import com.example.practiceJpa.payload.CourseDto;

import java.util.List;

public interface CourseService {
    void create(CourseDto courseDto);
    void  update(CourseDto courseDto);
    void  delete(int courseId);
    CourseDto getCourseWithId(int CourseId);
    List<CourseDto> getCourseWithPageable(int pageNo, int recordSize);

}
