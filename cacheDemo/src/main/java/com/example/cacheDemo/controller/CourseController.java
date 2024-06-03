package com.example.cacheDemo.controller;

import com.example.cacheDemo.model.Course;
import com.example.cacheDemo.service.CourseService;
import com.example.cacheDemo.service.serviceImp.CourseServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    @Autowired

    private final CourseServiceImp courseService;

    @PostMapping
    public ResponseEntity<String> createCourse(@RequestBody Course course) {
        boolean isCreated = courseService.createCourse(course);
        if (isCreated) {
            return new ResponseEntity<>("Course created successfully.", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Course creation failed.", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourse();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Optional<Course> course = courseService.getCourseByID(id);
        if (course.isPresent()) {
            return new ResponseEntity<>(course.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCourse(@RequestBody Course course, @PathVariable Long id) {
        try {
            Course updatedCourse = courseService.updateCourse(course, id);
            return new ResponseEntity<>("Course updated successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Course update failed.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        boolean isDeleted = courseService.deleteCourse(id);
        if (isDeleted) {
            return new ResponseEntity<>("Course deleted successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Course deletion failed.", HttpStatus.BAD_REQUEST);
        }
    }
}
