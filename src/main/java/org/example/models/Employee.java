package org.example.models;

public abstract class Employee {
    private String id;
    private String name;
    private String age;
    private String gender;
    private String address;
    private String birthDate;
    protected double baseSalary;

    public Employee(String id, String name, String age, String gender, String address, String birthDate, double baseSalary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.birthDate = birthDate;
        this.baseSalary = baseSalary;
    }

    public String getEmployeeName() {
        return name;
    }

    public String getEmployeeId() {
        return id;
    }

    public double calculateNetSalary() {
        double deductions = calculateDeductions();
        return baseSalary - deductions;
    }

    private double calculateIncomeTax(double salary) {
        if (salary <= 472.00) {
            return 0;
        } else if (salary <= 895.24) {
            return (salary - 472) * 0.1 + 17.67;
        } else if (salary <= 2038.10) {
            return (salary - 895.24) * 0.2 + 60;
        } else {
            return (salary - 2038.10) * 0.3 + 288.57;
        }
    }

    private double calculateDeductions() {
        double isss = 0.075 * baseSalary;
        double afp = 0.0775 * baseSalary;
        double renta = calculateIncomeTax(baseSalary);

        return isss + afp + renta;
    }
}

