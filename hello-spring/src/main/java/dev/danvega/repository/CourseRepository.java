package dev.danvega.repository;

import dev.danvega.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository implements CrudRepository<Course> {

    @Override
    public List<Course> findAll() {
        List<Course> courses = new ArrayList<>();
        Course springBoot = new Course(1,
                "Getting Started with Spring Boot 2",
                "Learn how to build a real application using Spring Framework 5 & Spring Boot 2",
                "https://www.danvega.dev/courses");
        courses.add(springBoot);
        return courses;
    }

}
