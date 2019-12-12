package edu.training.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
public class Employee {

    private String name;

    private LocalDate dateOfBirth;

    private LocalDate dateOfJoin;

    private String workingBlock;

    private int workingPlaceNumber;

    private Long salary;

    private Set<Skill> skills;

    public enum Skill {JAVA, C, PYTHON, KOTLIN, SCALA, GOLANG, JAVASCRIPT}
}
