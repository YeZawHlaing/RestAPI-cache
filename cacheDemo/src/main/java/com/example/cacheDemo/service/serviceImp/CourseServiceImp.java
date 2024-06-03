package com.example.cacheDemo.service.serviceImp;


import com.example.cacheDemo.model.Course;
import com.example.cacheDemo.repository.CourseRepo;
import com.example.cacheDemo.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class CourseServiceImp implements CourseService {

    @Autowired
    private final CourseRepo courseRepo;

   // private final Logger logger = (Logger) LoggerFactory.getLogger(CourseServiceImp.class);



    @Override
    public boolean createCourse(Course course) {
        courseRepo.save(course);
        return true;
    }

    @Override
    @Cacheable(value = "course")
    public List<Course> getAllCourse() {
      //  logger.info("Course list");
        return courseRepo.findAll();
    }

    @Override
    @Cacheable(value = "course",key = "#id")
    public Optional<Course> getCourseByID(Long id) {
      //  logger.info("courseId"+id);
        return courseRepo.findById(id);
    }

    @Override
    @CachePut(value = "course",key = "#course.id")
    public Course updateCourse(Course course, Long id) {
       // logger.info("updated");
        Course updateCourse=courseRepo.save(course);
        return updateCourse;
    }

    @Override
    @CacheEvict(value = "course",allEntries = true)
    public boolean deleteCourse(Long id) {
        if (courseRepo.existsById(id)) {
            courseRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
