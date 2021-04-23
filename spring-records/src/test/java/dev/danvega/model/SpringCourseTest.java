package dev.danvega.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SpringCourseTest {

    private static SpringCourse course;

    @BeforeAll
    static void beforeAll() {
        course = new SpringCourse(1,
                "Getting Started with Spring Boot 2",
                "Learn how to build a real applications using Spring Framework 5 & Spring Boot 2",
                "https://www.danvega.dev/courses");
    }

    @Test
    public void shouldReturnCorrectValuesFromAccessors() {
        int id = 1;
        String name = "Getting Started with Spring Boot 2";
        String desc = "Learn how to build a real applications using Spring Framework 5 & Spring Boot 2";
        String link = "https://www.danvega.dev/courses";

        assertEquals(1,course.id());
        assertEquals(name,course.name());
        assertEquals(desc,course.desc());
        assertEquals(link,course.link());
    }

    @Test
    public void shouldReturnTrueWhenRecordValuesAreEqual() {
        SpringCourse springBoot = new SpringCourse(1,
                "Getting Started with Spring Boot 2",
                "Learn how to build a real applications using Spring Framework 5 & Spring Boot 2",
                "https://www.danvega.dev/courses");

        assertTrue(course.equals(springBoot));
    }

    @Test
    public void shouldReturnCorrectHashCode() {
        SpringCourse springBoot = new SpringCourse(1,
                "Getting Started with Spring Boot 2",
                "Learn how to build a real applications using Spring Framework 5 & Spring Boot 2",
                "https://www.danvega.dev/courses");

        assertEquals(course.hashCode(),springBoot.hashCode());
    }

}
