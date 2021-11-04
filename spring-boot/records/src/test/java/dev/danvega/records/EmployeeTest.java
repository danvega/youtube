package dev.danvega.records;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmployeeTest {

    @Test
    void testValidEmployee() {
        Employee e = new Employee(1, "Dan", "Vega", "danvega@gmail.com");

        assertEquals(1,e.id());
        assertEquals("Dan",e.firstName());
        assertEquals("Vega",e.lastName());
        assertEquals("danvega@gmail.com",e.email());
    }

    @Test
    void invalidEmployeeShouldThrowIllegalArgumentException() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            new Employee(1, "Dan", "Vega", "");
        });
        assertEquals("Email cannot be empty", illegalArgumentException.getMessage());
    }
}
