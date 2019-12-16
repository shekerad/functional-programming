package edu.training;

import edu.training.domain.Employee;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static edu.training.EmployeeUtil.employee1;
import static edu.training.EmployeeUtil.employee3;
import static edu.training.EmployeeUtil.employee4;
import static edu.training.EmployeeUtil.employee5;
import static edu.training.EmployeeUtil.getCompanies;
import static edu.training.EmployeeUtil.getEmployees;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StreamApiTest {

    @Test
    void getEmployeeNames() {
        List<String> actual = StreamApi.getEmployeeNames(getEmployees());
        assertThat(actual)
                .hasSize(6)
                .contains("Ivan", "Olesia", "Danylo", "Kateryna", "Petro", "Ivan");
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
        assertEquals(List.of("Danylo", "Ivan", "Ivan", "Kateryna", "Olesia", "Petro"), actual);
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
                .hasSize(4)
                .contains(employee3, employee4, employee5, employee1);
    }

    @Test
    void getEmployeeNamesWithTop3Salary() {
        List<String> actual = StreamApi.getEmployeeNamesWithTop3Salary(getEmployees());
        assertThat(actual)
                .hasSize(3)
                .contains("Kateryna", "Danylo", "Olesia");
    }

    @Test
    void getEmployeeHiredInYearSortedByNames() {
        List<Employee> actual = StreamApi.getEmployeeHiredInYearSortedByNames(getEmployees(), 2018);
        assertEquals(List.of(employee4, employee5), actual);
    }

    @Test
    void getEmployeeHiredInYearSortedByNamesEmptyResult() {
        List<Employee> actual = StreamApi.getEmployeeHiredInYearSortedByNames(getEmployees(), 2010);
        assertEquals(Collections.emptyList(), actual);
    }

    @Test
    void getUniqueEmployeeNames() {
        List<String> actual = StreamApi.getUniqueEmployeeNames(getEmployees());
        assertThat(actual).hasSize(5).contains("Ivan", "Olesia", "Danylo", "Kateryna", "Petro");
    }

    @Test
    void isAnyEmployeeWithName() {
        boolean actual = StreamApi.isAnyEmployeeWithName(getEmployees(), "Danylo");
        assertTrue(actual);
    }

    @Test
    void isAnyEmployeeWithNameNegative() {
        boolean actual = StreamApi.isAnyEmployeeWithName(getEmployees(), "Olena");
        assertFalse(actual);
    }

    @Test
    void isAnyEmployeeWithNameWorksInBlock() {
        boolean actual = StreamApi.isAnyEmployeeWithNameWorksInBlock(getEmployees(), "Petro", "4L");
        assertTrue(actual);
    }

    @Test
    void isAnyEmployeeWithNameWorksInBlockNegative() {
        boolean actual = StreamApi.isAnyEmployeeWithNameWorksInBlock(getEmployees(), "Petro", "3K");
        assertFalse(actual);
    }

    @Test
    void isAnyEmployeeWithSalaryLessThan() {
        boolean actual = StreamApi.isAnyEmployeeWithSalaryLessThan(getEmployees(), 500);
        assertTrue(actual);
    }

    @Test
    void isAnyEmployeeWithSalaryLessThanNegative() {
        boolean actual = StreamApi.isAnyEmployeeWithSalaryLessThan(getEmployees(), 100);
        assertFalse(actual);
    }

    @Test
    void getTotalCompanySalary() {
        long actual = StreamApi.getTotalCompanySalary(getEmployees());
        assertEquals(1620, actual);
    }

    @Test
    void raiseSalaryForAllCompany() {
        List<Employee> employees = getEmployees().stream().map(SerializationUtils::clone).collect(Collectors.toList());
        StreamApi.raiseSalaryForAllEmployees(employees, 100);
        assertThat(employees).extracting(Employee::getSalary)
                .contains(300L, 400L, 410L, 570L, 240L, 300L);
    }

    @Test
    void countNumberOfEmployeesWithSalaryMoreThan() {
        int actual = StreamApi.countNumberOfEmployeesWithSalaryMoreThan(getEmployees(), 400);
        assertEquals(1, actual);
    }

    @Test
    void calculateMaxSalaryOnMarket() {
        long actual = StreamApi.calculateMaxSalaryOnMarket(getCompanies());
        assertEquals(470L, actual);
    }
}