package edu.training;

import edu.training.domain.Employee;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class EmployeeUtil {

    private static Employee employee1 = Employee.builder()
            .name("Ivan")
            .dateOfBirth(LocalDate.of(1992, 3, 2))
            .dateOfJoin(LocalDate.of(2015, 9, 1))
            .salary(200L)
            .workingBlock("3K")
            .workingPlaceNumber(62)
            .skills(Set.of(Employee.Skill.JAVA))
            .build();

    private static Employee employee2 = Employee.builder()
            .name("Olesia")
            .dateOfBirth(LocalDate.of(1995, 5, 24))
            .dateOfJoin(LocalDate.of(2017, 1, 5))
            .salary(300L)
            .workingBlock("3C")
            .workingPlaceNumber(15)
            .skills(Set.of(Employee.Skill.PYTHON))
            .build();

    private static Employee employee3 = Employee.builder()
            .name("Danylo")
            .dateOfBirth(LocalDate.of(1981, 5, 21))
            .dateOfJoin(LocalDate.of(2019, 6, 14))
            .salary(310L)
            .workingBlock("2R")
            .workingPlaceNumber(12)
            .skills(Set.of(Employee.Skill.JAVA, Employee.Skill.GOLANG))
            .build();

    private static Employee employee4 = Employee.builder()
            .name("Kateryna")
            .dateOfBirth(LocalDate.of(1981, 5, 21))
            .dateOfJoin(LocalDate.of(2018, 10, 12))
            .salary(470L)
            .workingBlock("6R")
            .workingPlaceNumber(12)
            .skills(Set.of(Employee.Skill.JAVA, Employee.Skill.SCALA))
            .build();

    private static Employee employee5 = Employee.builder()
            .name("Petro")
            .dateOfBirth(LocalDate.of(1981, 5, 21))
            .dateOfJoin(LocalDate.of(2018, 10, 12))
            .salary(140L)
            .workingBlock("4L")
            .workingPlaceNumber(12)
            .skills(Set.of(Employee.Skill.KOTLIN))
            .build();

    static  List<Employee> getEmployees() {
        return List.of(employee1,employee2, employee3, employee4, employee5);
    }
}
