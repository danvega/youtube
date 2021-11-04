package dev.danvega.records;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJdbcTest
@ActiveProfiles("test")
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository repository;

    @BeforeEach
    void setUp() {
        List<Employee> employees = List.of(new Employee(null, "Dan", "Vega", "danvega@gmail.com"),
                new Employee(null, "John", "Doe", "johndoe@gmail.com"),
                new Employee(null, "Jane", "Doe", "janedoe@gmail.com"));

        repository.saveAll(employees);
    }

    @Test
    void findAllEmployeesShouldReturnAllEmployees() {
        assertEquals(3, StreamSupport.stream(repository.findAll().spliterator(), false).count());
    }

}
