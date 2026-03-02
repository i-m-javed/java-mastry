package main.java.callable_and_storedprocedure;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    \n1. Insert Employee
                    2. Get all Employee
                    3. Exit
                    """);
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter name:");
                    String name = scanner.nextLine();

                    System.out.print("Enter salary: ");
                    double salary = scanner.nextDouble();

                    if (employeeService.insertEmployee(name, salary)) {
                        System.out.println("Employee inserted");
                    } else {
                        System.out.println("Failed to insert");
                    }
                }

                case 2 -> {
                    List<Employees> employees = employeeService.getAllEmployees();
                    if (employees == null || employees.isEmpty()) {
                        System.out.println("No data found.");
                    } else {
                        printEmployees(employees);
                    }
                }

                case 3 -> {
                    System.out.println("Exiting application.....");
                    exit(0);
                }

                default -> System.out.println("Invalid Input....try again");

            }
        }
    }

    static void printEmployees(List<Employees> employees) {

        System.out.println("\n----------------------------------");
        System.out.printf("%-5s %-15s %-12s%n",
                "ID", "Name", "Salary");
        System.out.println("----------------------------------");

        for (Employees e : employees) {
            System.out.printf("%-5d %-15s %-12s%n",
                    e.getId(),
                    e.getName(),
                    e.getSal());
        }
    }
}
