package com.example.cacheDemo.service;

import com.example.cacheDemo.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    boolean createCourse(Course course);

    List<Course> getAllCourse();

    Optional<Course> getCourseByID(Long id);

    Course updateCourse(Course course, Long id);

    boolean deleteCourse(Long id);

}
