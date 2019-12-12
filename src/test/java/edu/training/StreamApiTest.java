package edu.training;

import edu.training.domain.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StreamApiTest {

    @Test
    void getEmployeeNames() {
        List<Employee> employees = EmployeeUtil.getEmployees();
        List<String> actual = StreamApi.getEmployeeNames(employees);


    }
}