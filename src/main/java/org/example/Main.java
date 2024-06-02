package org.example;

import org.example.models.Company;
import org.example.models.Employee;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Create a Company instance
        Company myCompany = new Company();

        // Get all employees (original order)
        System.out.println("**Employees (Original Order):**");
        printEmployeeDetails(myCompany.getEmployees());

        // Get employees sorted by last name
        System.out.println("\n**Employees by Last Name:**");
        printEmployeeDetails(myCompany.getEmployeesByLastName());

        // Get employees sorted by net salary (ascending)
        System.out.println("\n**Employees by Net Salary (Ascending):**");
        printEmployeeDetails(myCompany.getEmployeesByNetSalary(false));

        // Get employees sorted by net salary (descending)
        System.out.println("\n**Employees by Net Salary (Descending):**");
        printEmployeeDetails(myCompany.getEmployeesByNetSalary(true));

        // Get employee count by role
        System.out.println("\n**Employee Count by Role:**");
        Map<String, Integer> roles = myCompany.countEmployeesByRole();

        for (Map.Entry<String, Integer> entry : roles.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static void printEmployeeDetails(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println("  - ID: " + employee.getEmployeeId());
            System.out.println("    Name: " + employee.getEmployeeName());
            System.out.println("    Net Salary: $" + String.format("%.2f", employee.calculateNetSalary()));
            System.out.println();
        }
    }
}