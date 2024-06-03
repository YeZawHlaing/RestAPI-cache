package com.example.cacheDemo.repository;

import com.example.cacheDemo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Long> {
}
