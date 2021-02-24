package dev.danvega.dao;

import dev.danvega.model.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJdbcTest
@Import(CourseJdbcDAO.class)
class CourseJdbcDAOTest {

    @Autowired
    private CourseJdbcDAO dao;

    @Test
    void contextLoads() {
        assertNotNull(dao);
    }

    @Test
    void list() {
        assertEquals(5,dao.list().size());
    }

    @Test
    void create() {
        Course course = new Course(99,"TEST_TITLE","TEST_DESC","http://www.danvega.dev");
        Course saved = dao.create(course);

        assertEquals(6,dao.list().size());
        assertEquals(99,saved.getCourseId());
        assertEquals("TEST_TITLE",saved.getTitle());
        assertEquals("TEST_DESC",saved.getDescription());
        assertEquals("http://www.danvega.dev",saved.getLink());
    }

    @Test
    void get() {
        Course course = dao.get(1).get();
        assertEquals(1,course.getCourseId());
        assertEquals("Vue.js for Beginners: Up and Running with Vue",course.getTitle());
        assertEquals("A beginner's guide to learn the basics of the JavaScript Framework Vue.js.",course.getDescription());
        assertEquals("https://www.udemy.com/course/vue-intro/?referralCode=E9DECFF78CA706D7A68A",course.getLink());
    }

    @Test
    void update() {
        Course course = dao.get(1).get();
        course.setTitle("UPDATED_TITLE");
        dao.update(course,1);

        Course updated = dao.get(1).get();
        assertEquals("UPDATED_TITLE",updated.getTitle());
    }

    @Test
    void delete() {
        dao.delete(1);
        assertEquals(4,dao.list().size());
    }
}
