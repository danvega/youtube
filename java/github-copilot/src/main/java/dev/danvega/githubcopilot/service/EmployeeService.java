package dev.danvega.githubcopilot.service;

import dev.danvega.githubcopilot.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    List<Employee> employees = new ArrayList<>();

    public EmployeeService() {
        employees.add(new Employee(1,"Dan Vega", "danvega@gmail.com"));
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployee(int id) {
        return employees.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void updateEmployee(Employee employee) {
        Employee e = getEmployee(employee.getId());
        e.setName(employee.getName());
        e.setEmail(employee.getEmail());
    }

    public void deleteEmployee(int id) {
        employees.removeIf(e -> e.getId() == id);
    }

}
