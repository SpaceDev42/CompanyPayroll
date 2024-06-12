package org.example.menu;

import org.example.interfaces.MenuPresentation;
import org.example.models.Company;
import org.example.models.Employee;
import org.example.models.JobPosition;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static org.example.models.JobPosition.*;

public class ConsoleMenu implements MenuPresentation {
    private final Company company;

    public ConsoleMenu(Company company) {
        this.company = company;
    }

    private void presentEmployeesByLastName() {
        List<Employee> employees = company.sortEmployeesByLastName();

        System.out.println("\nEmpleados ordenados por apellido:");
        for (Employee employee : employees) System.out.println(employee.getEmployeeName());
    }

    private void presentEmployeesByNetSalary() {
        List<Employee> employees = company.sortEmployeesByNetSalary(true);

        System.out.println("\nEmpleados ordenados por sueldo con descuentos:");
        for (Employee employee : employees) {
            String statement = employee.getEmployeeName()
                    .concat(" - Salario con descuentos: ")
                    .concat(String.valueOf(employee.calculateNetSalary()));

            System.out.println(statement);
        }
    }

    private void presentCountByRoles() {
        Map<JobPosition, Integer> roles = company.countEmployeesByRole();

        System.out.println("\nCantidad de empleados según sus roles:");
        System.out.println("Gerentes: " + roles.get(MANAGER));
        System.out.println("Técnicos: " + roles.get(TECHNICIAN));
        System.out.println("Jefes de Área: " + roles.get(AREA_CHIEF));
        System.out.println("Supervisores: "+ roles.get(SUPERVISOR));
    }

    @Override
    public void presentOptions() {
        int option;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Ordenar empleados alfabéticamente por primer apellido");
            System.out.println("2. Ordenar empleados por sueldo con descuentos");
            System.out.println("3. Mostrar cantidad de empleados según sus roles");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            option = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (option) {
                case 1:
                    presentEmployeesByLastName();
                    break;
                case 2:
                    presentEmployeesByNetSalary();
                    break;
                case 3:
                    presentCountByRoles();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (option != 4);

        scanner.close();
    }
}
