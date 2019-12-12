package edu.training;

import edu.training.domain.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;

import static edu.training.EmployeeUtil.employee1;
import static edu.training.EmployeeUtil.employee3;
import static edu.training.EmployeeUtil.employee4;
import static edu.training.EmployeeUtil.employee5;
import static edu.training.EmployeeUtil.getEmployees;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StreamApiTest {

    @Test
    void getEmployeeNames() {
        List<String> actual = StreamApi.getEmployeeNames(getEmployees());
        assertThat(actual)
                .hasSize(5)
                .contains("Ivan", "Olesia", "Danylo", "Kateryna", "Petro");
    }

    @Test
    void getEmployeeNamesStartedFrom() {
        List<String> actual = StreamApi.getEmployeeNamesStartedFrom(getEmployees(), "D");
        assertThat(actual)
                .hasSize(1)
                .contains("Danylo");
    }

    @Test
    void getEmployeeNamesSorted() {
        List<String> actual = StreamApi.getEmployeeNamesSorted(getEmployees());
        assertEquals(List.of("Danylo", "Ivan", "Kateryna", "Olesia", "Petro"), actual);
    }

    @Test
    void getEmployeeJoinCompanyIn2019() {
        List<Employee> actual = StreamApi.getEmployeeJoinCompanyIn2019(getEmployees());
        assertThat(actual)
                .hasSize(1)
                .contains(employee3);
    }

    @Test
    void getEmployeeWithJava() {
        List<Employee> actual = StreamApi.getEmployeesWithJava(getEmployees());
        assertThat(actual)
                .hasSize(3)
                .contains(employee1, employee3, employee4);
    }

    @Test
    void getEmployeesWithJava() {
        List<Employee> actual = StreamApi.getEmployeesFrom3KBlock(getEmployees());
        assertThat(actual)
                .hasSize(1)
                .contains(employee1);
    }

    @Test
    void getEmployeesOlderThan25Years() {
        List<Employee> actual = StreamApi.getEmployeesOlderThan25Years(getEmployees());
        assertThat(actual)
                .hasSize(3)
                .contains(employee3, employee4, employee5);
    }

    @Test
    void getEmployeeNamesWithTop5Salary() {
        List<String> actual = StreamApi.getEmployeeNamesWithTop3Salary(getEmployees());
        assertThat(actual)
                .hasSize(3)
                .contains("Kateryna", "Danylo", "Olesia");
    }
}