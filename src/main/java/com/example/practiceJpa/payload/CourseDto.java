package com.example.practiceJpa.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
    private String courseTitle;
    private int creditHour;
    private List<StudentDto> studentDto;
}
