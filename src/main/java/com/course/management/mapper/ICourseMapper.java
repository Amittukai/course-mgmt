package com.course.management.mapper;

import com.course.management.dtos.CourseDto;
import com.course.management.entities.Course;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICourseMapper {

    Course convertTo(CourseDto courseDto);

    CourseDto convertToDto(Course course);

    List<Course> map(List<CourseDto> courseDtoList);

    List<CourseDto> mapToDto(List<Course> courseList);
}
