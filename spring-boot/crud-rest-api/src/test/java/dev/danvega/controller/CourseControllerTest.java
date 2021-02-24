package dev.danvega.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.danvega.dao.DAO;
import dev.danvega.model.Course;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CourseController.class)
class CourseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DAO<Course> dao;

    @Autowired
    private ObjectMapper objectMapper;

    private static List<Course> courses;

    @BeforeAll
    static void beforeAll() {
        courses = List.of(new Course(1,"test_title","test_desc","http://www.danvega.dev"));
    }

    @Test
    void contextLoads() {
        assertNotNull(mockMvc);
        assertNotNull(dao);
        assertNotNull(objectMapper);
    }

    @Test
    public void list_ShouldReturnAllCourses() throws Exception {

        when(dao.list()).thenReturn(courses);

        mockMvc.perform(get("/courses"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(courses.size())))
                .andExpect(jsonPath("$[0].courseId", is(1)))
                .andExpect(jsonPath("$[0].title", is("test_title")))
                .andExpect(jsonPath("$[0].description", is("test_desc")))
                .andExpect(jsonPath("$[0].link", is("http://www.danvega.dev")));
    }

    @Test
    public void get_ShouldReturnOneCourseById() throws Exception {
        final int courseId = 1;
        final Course course = new Course(courseId,"test_title","test_desc","http://www.danvega.dev");

        when(dao.get(courseId)).thenReturn(Optional.of(course));

        mockMvc.perform(get("/courses/{id}", courseId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is(course.getTitle())))
                .andExpect(jsonPath("$.description", is(course.getDescription())))
                .andExpect(jsonPath("$.link", is(course.getLink())));
    }

    @Test
    public void shouldReturn404WithInvalidCourseId() throws Exception {
        final int courseId = 99;

        when(dao.get(courseId)).thenReturn(Optional.empty());

        mockMvc.perform(get("/courses/{id}", courseId))
                .andExpect(status().isNotFound());
    }

    @Test
    public void create_ValidCourse_ShouldCreateNewCourse() throws Exception {
        Course course = new Course("test_title","test_desc","http://www.danvega.dev");
        when(dao.create(course)).thenReturn(course);

        this.mockMvc
                .perform(post("/courses")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(course)))
                .andExpect(status().isCreated());
    }

    @Test
    public void create_InvalidCourse_ShouldReturn400BadRequest() throws Exception {
        Course course = new Course("test_title","test_desc","not_a_url");
        when(dao.create(course)).thenReturn(course);

        this.mockMvc
                .perform(post("/courses")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(course)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void update_ValidCourse_ShouldUpdateExistingCourse() throws Exception {
        Course course = new Course("updated_title","updated_desc","http://www.danvega.dev");
        doNothing().when(dao).update(course,1);

        this.mockMvc
                .perform(put("/courses/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(course)))
                .andExpect(status().isNoContent());
    }

    @Test
    public void update_InvalidCourse_ShouldReturn400BadRequest() throws Exception {
        Course course = new Course("updated_title","updated_desc","not_a_url");
        doNothing().when(dao).update(course,1);

        mockMvc
                .perform(put("/courses/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(course)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void delete_ValidCourseId_ShouldDeleteCourse() throws Exception {
        doNothing().when(dao).delete(1);
        mockMvc.perform(delete("/courses/1")).andExpect(status().isNoContent());
    }


}
