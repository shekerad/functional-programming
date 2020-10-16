package edu.training;

import edu.training.domain.Company;
import edu.training.domain.Employee;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class EmployeeUtil {

    static Employee employee1 = Employee.builder()
            .name("Ivan")
            .dateOfBirth(LocalDate.of(1992, 3, 2))
            .dateOfJoin(LocalDate.of(2015, 9, 1))
            .salary(200L)
            .workingBlock("3K")
            .workingPlaceNumber(62)
            .skills(Set.of(Employee.Skill.JAVA))
            .build();

    static Employee employee2 = Employee.builder()
            .name("Olesia")
            .dateOfBirth(LocalDate.of(1997, 5, 24))
            .dateOfJoin(LocalDate.of(2017, 1, 5))
            .salary(300L)
            .workingBlock("3C")
            .workingPlaceNumber(15)
            .skills(Set.of(Employee.Skill.PYTHON))
            .build();

    static Employee employee3 = Employee.builder()
            .name("Danylo")
            .dateOfBirth(LocalDate.of(1987, 5, 21))
            .dateOfJoin(LocalDate.of(2019, 6, 14))
            .salary(310L)
            .workingBlock("2R")
            .workingPlaceNumber(12)
            .skills(Set.of(Employee.Skill.JAVA, Employee.Skill.GOLANG))
            .build();

    static Employee employee4 = Employee.builder()
            .name("Kateryna")
            .dateOfBirth(LocalDate.of(1981, 5, 21))
            .dateOfJoin(LocalDate.of(2018, 10, 12))
            .salary(470L)
            .workingBlock("6R")
            .workingPlaceNumber(12)
            .skills(Set.of(Employee.Skill.JAVA, Employee.Skill.SCALA))
            .build();

    static Employee employee5 = Employee.builder()
            .name("Petro")
            .dateOfBirth(LocalDate.of(1985, 5, 21))
            .dateOfJoin(LocalDate.of(2018, 10, 12))
            .salary(140L)
            .workingBlock("4L")
            .workingPlaceNumber(12)
            .skills(Set.of(Employee.Skill.KOTLIN))
            .build();

    static Employee employee6 = Employee.builder()
            .name("Ivan")
            .dateOfBirth(LocalDate.of(1999, 6, 25))
            .dateOfJoin(LocalDate.of(2016, 10, 12))
            .salary(200L)
            .workingBlock("5C")
            .workingPlaceNumber(22)
            .skills(Set.of(Employee.Skill.JAVASCRIPT))
            .build();


    static List<Employee> getEmployees() {
        return List.of(employee1, employee2, employee3, employee4, employee5, employee6);
    }

    static List<Company> getCompanies() {
        List<Employee> employees = getEmployees();
        Company company = new Company();
        company.setEmployees(employees);
        return List.of(company);
    }
}
