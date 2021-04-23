package dev.danvega.controller;

import dev.danvega.model.SpringCourse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/spring")
public class SpringCourseController {

    private List<SpringCourse> courses = new ArrayList<>();

    public SpringCourseController() {
        SpringCourse course = new SpringCourse(1,"Spring Boot 2","TEST","TEST");
        courses.add(course);
    }

    @GetMapping
    public List<SpringCourse> getAllCourses() {
        return courses;
    }

    @GetMapping("/first")
    public String getFirstCourseName() {
        return courses.get(0).name();
    }

}
