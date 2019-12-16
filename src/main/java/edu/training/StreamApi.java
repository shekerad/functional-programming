package edu.training;

import edu.training.domain.Company;
import edu.training.domain.Employee;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApi {

    public static List<String> getEmployeeNames(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
    }

    public static List<String> getEmployeeNamesStartedFrom(List<Employee> employees, String strStart) {
        return employees.stream()
                .filter(employee -> employee.getName().startsWith(strStart))
                .map(Employee::getName)
                .collect(Collectors.toList());
    }

    public static List<String> getEmployeeNamesSorted(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<Employee> getEmployeeJoinCompanyIn2019(List<Employee> employees) {
        return employees.stream()
                .filter(employee -> employee.getDateOfJoin().getYear() == 2019)
                .collect(Collectors.toList());
    }

    public static List<Employee> getEmployeesWithJava(List<Employee> employees) {
        return employees.stream()
                .filter(employee -> employee.getSkills().contains(Employee.Skill.JAVA))
                .collect(Collectors.toList());
    }

    public static List<Employee> getEmployeesFrom3KBlock(List<Employee> employees) {
        return employees.stream()
                .filter(employee -> employee.getWorkingBlock().equals("3K"))
                .collect(Collectors.toList());
    }

    public static List<Employee> getEmployeesOlderThan25Years(List<Employee> employees) {
        return employees.stream()
                .filter(employee -> LocalDate.now().minusYears(25).isAfter(employee.getDateOfBirth()))
                .collect(Collectors.toList());
    }

    public static List<String> getEmployeeNamesWithTop3Salary(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .map(Employee::getName)
                .limit(3)
                .collect(Collectors.toList());
    }

    public static List<Employee> getEmployeeHiredInYearSortedByNames(List<Employee> employees, int year) {
        return employees.stream()
                .filter(employee -> employee.getDateOfJoin().getYear() == year)
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());

    }

    public static List<String> getUniqueEmployeeNames(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getName)
                .distinct()
                .collect(Collectors.toList());
    }

    public static boolean isAnyEmployeeWithName(List<Employee> employees, String name) {
        return employees.stream()
                .anyMatch(employee -> employee.getName().equals(name));
    }

    public static boolean isAnyEmployeeWithNameWorksInBlock(List<Employee> employees, String name, String block) {
        return employees.stream()
                .filter(employee -> employee.getWorkingBlock().equals(block))
                .anyMatch(employee -> employee.getName().equals(name));
    }

    public static boolean isAnyEmployeeWithSalaryLessThan(List<Employee> employees, int salary) {
        return employees.stream()
                .anyMatch(employee -> employee.getSalary() < salary);
    }

    public static long getTotalCompanySalary(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getSalary)
                .reduce(0L, Long::sum);
    }

    public static void raiseSalaryForAllEmployees(List<Employee> employees, int raiseValue) {
        employees.forEach(employee -> employee.setSalary(employee.getSalary() + raiseValue));
    }

    public static int countNumberOfEmployeesWithSalaryMoreThan(List<Employee> employees, int salary) {
        return (int) employees.stream()
                .filter(employee -> employee.getSalary() > salary)
                .count();
    }

    public static long calculateMaxSalaryOnMarket(List<Company> companies) {
        return companies.stream()
                .flatMap(company -> company.getEmployees().stream())
                .map(Employee::getSalary)
                .reduce(0L, (a, b) -> a > b ? a : b);
    }

}
