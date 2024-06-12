package org.example.interfaces;

import org.example.models.Employee;
import org.example.models.JobPosition;

import java.util.List;
import java.util.Map;

public interface EmployeesSorting {
    List<Employee> sortEmployeesByLastName();
    List<Employee> sortEmployeesByNetSalary(boolean descending);
    Map<JobPosition, Integer> countEmployeesByRole();
}
