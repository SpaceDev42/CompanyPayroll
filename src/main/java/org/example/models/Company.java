package org.example.models;

import java.util.*;

public class Company {
    private List<Employee> employees;

    public Company() {
        employees = new ArrayList<>();
        addEmployees();
    }

    private void addEmployees() {
        // Add 2 managers
        employees.add(new Manager("1", "Juan Pérez", "40", "M", "Calle Principal 123", "1980-01-01"));
        employees.add(new Manager("2", "María García", "35", "F", "Calle Elm 456", "1985-02-02"));

        // Add 3 area chiefs
        employees.add(new AreaChief("3", "Roberto Hernández", "45", "M", "Calle Maple 789", "1975-03-03"));
        employees.add(new AreaChief("4", "Ana Martínez", "40", "F", "Calle Oak 101", "1980-04-04"));
        employees.add(new AreaChief("5", "Carlos Rodríguez", "35", "M", "Calle Pine 202", "1985-05-05"));

        // Add 5 supervisors
        employees.add(new Supervisor("6", "Eva González", "41", "F", "Calle Cedar 303", "1979-06-06"));
        employees.add(new Supervisor("7", "Francisco López", "42", "M", "Calle Birch 404", "1978-07-07"));
        employees.add(new Supervisor("8", "Gracia Sánchez", "43", "F", "Calle Cherry 505", "1977-08-08"));
        employees.add(new Supervisor("9", "Héctor Ramírez", "44", "M", "Calle Walnut 606", "1976-09-09"));
        employees.add(new Supervisor("10", "Irene Torres", "45", "F", "Calle Ash 707", "1975-10-10"));

        // Add 15 technicians
        employees.add(new Technician("11", "Luis Pérez", "30", "M", "Calle Roble 111", "1990-07-07"));
        employees.add(new Technician("12", "Carmen Ramírez", "31", "F", "Calle Sauce 222", "1989-07-07"));
        employees.add(new Technician("13", "Mario López", "32", "M", "Calle Encino 333", "1988-07-07"));
        employees.add(new Technician("14", "Laura Morales", "33", "F", "Calle Pino 444", "1987-07-07"));
        employees.add(new Technician("15", "Pedro González", "34", "M", "Calle Olmo 555", "1986-07-07"));
        employees.add(new Technician("16", "Ana Torres", "35", "F", "Calle Fresno 666", "1985-07-07"));
        employees.add(new Technician("17", "Hugo Fernández", "36", "M", "Calle Acacia 777", "1984-07-07"));
        employees.add(new Technician("18", "Julia Méndez", "37", "F", "Calle Abedul 888", "1983-07-07"));
        employees.add(new Technician("19", "Ricardo Vázquez", "38", "M", "Calle Castaño 999", "1982-07-07"));
        employees.add(new Technician("20", "María Jiménez", "39", "F", "Calle Nogal 1000", "1981-07-07"));
        employees.add(new Technician("21", "Miguel Ortiz", "40", "M", "Calle Arce 1011", "1980-07-07"));
        employees.add(new Technician("22", "Patricia Flores", "41", "F", "Calle Sauce 2222", "1979-07-07"));
        employees.add(new Technician("23", "Javier Rivera", "42", "M", "Calle Cedro 3033", "1978-07-07"));
        employees.add(new Technician("24", "Adriana Soto", "43", "F", "Calle Haya 4044", "1977-07-07"));
        employees.add(new Technician("25", "Diego Herrera", "44", "M", "Calle Olmo 5055", "1976-07-07"));
    }


    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Employee> getEmployeesByLastName() {
        List<Employee> sortedEmployees = new ArrayList<>(employees);
        sortedEmployees.sort(Comparator.comparing(e -> e.getEmployeeName().split(" ")[1]));
        return sortedEmployees;
    }

    public List<Employee> getEmployeesByNetSalary(boolean descending) {
        List<Employee> sortedEmployees = new ArrayList<>(employees);
        sortedEmployees.sort(Comparator.comparingDouble(Employee::calculateNetSalary));
        if (descending) {
            Collections.reverse(sortedEmployees);
        }
        return sortedEmployees;
    }

    public Map<String, Integer> countEmployeesByRole() {
        Map<String, Integer> roles = new HashMap<>();
        roles.put("Manager", 0);
        roles.put("Technician", 0);
        roles.put("AreaChief", 0);
        roles.put("Supervisor", 0);

        for (Employee employee : employees) {
            if (employee instanceof Manager) {
                roles.put("Manager", roles.get("Manager") + 1);
            } else if (employee instanceof Technician) {
                roles.put("Technician", roles.get("Technician") + 1);
            } else if (employee instanceof AreaChief) {
                roles.put("AreaChief", roles.get("AreaChief") + 1);
            } else if (employee instanceof Supervisor) {
                roles.put("Supervisor", roles.get("Supervisor") + 1);
            }
        }
        return roles;
    }
}
