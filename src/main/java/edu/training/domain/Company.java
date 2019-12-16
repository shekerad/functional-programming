package edu.training.domain;

import lombok.Data;

import java.util.List;

@Data
public class Company {

    private List<Employee> employees;
}
