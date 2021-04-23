package dev.danvega.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("dev.danvega")
public class AppConfig {


    //    @Bean
//    public CourseRepository getCourseRepository() {
//        return new CourseRepository();
//    }
//
//    @Bean("courseService")
//    public CourseService getCourseService() {
//        return new CourseService(getCourseRepository());
//    }

}
