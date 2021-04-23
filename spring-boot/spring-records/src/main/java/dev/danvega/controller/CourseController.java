package dev.danvega.controller;

import dev.danvega.model.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private List<Course> courses = new ArrayList<>();

    public CourseController() {
        Course course = new Course();
        course.setId(1);
        course.setName("Getting started with Spring Boot 2");
        course.setDescription("Test");
        course.setLink("https://www.danvega.dev");
        courses.add(course);
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courses;
    }

    @GetMapping("/first")
    public String getFirstCourseName() {
        return courses.get(0).getName();
    }
}
