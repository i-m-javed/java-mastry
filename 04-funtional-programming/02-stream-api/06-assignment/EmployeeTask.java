import java.util.*;
public class EmployeeTask{

    // =========================
    // Employee Class
    // =========================
    static class Employee {
        private int id;
        private String name;
        private String department;
        private String jobTitle;
        private int age;
        private int yearsOfExperience;
        private double salary;
        private int performanceRating;

        public Employee(int id, String name, String department,
                        String jobTitle, int age,
                        int yearsOfExperience,
                        double salary, int performanceRating) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.jobTitle = jobTitle;
            this.age = age;
            this.yearsOfExperience = yearsOfExperience;
            this.salary = salary;
            this.performanceRating = performanceRating;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public String getDepartment() { return department; }
        public String getJobTitle() { return jobTitle; }
        public int getAge() { return age; }
        public int getYearsOfExperience() { return yearsOfExperience; }
        public double getSalary() { return salary; }
        public int getPerformanceRating() { return performanceRating; }
    }

    // =========================
    // Add Employees
    // =========================
    public static List<Employee> addEmployees() {
        return List.of(
                new Employee(1, "Ravi", "IT", "Manager", 48, 3, 110000, 3),
                new Employee(2, "Anjali", "HR", "HR Executive", 32, 7, 60000, 4),
                new Employee(3, "Karan", "Finance", "Accountant", 29, 5, 55000, 3),
                new Employee(4, "Meera", "IT", "Software Engineer", 26, 3, 75000, 5),
                new Employee(5, "Arjun", "Sales", "Sales Executive", 35, 10, 65000, 4),
                new Employee(6, "Priya", "Marketing", "Marketing Manager", 40, 12, 90000, 5),
                new Employee(7, "Vikram", "IT", "DevOps Engineer", 30, 6, 80000, 4),
                new Employee(8, "Sneha", "Finance", "Financial Analyst", 28, 4, 58000, 3),
                new Employee(9, "Rahul", "Operations", "Operations Manager", 45, 15, 95000, 5),
                new Employee(10, "Neha", "HR", "Recruiter", 27, 3, 50000, 4),
                new Employee(11, "Amit", "Sales", "Manager", 38, 11, 88000, 5)
        );
    }

    // =========================
    // MAIN
    // =========================
    public static void main(String[] args) {

        List<Employee> employees = addEmployees();

        // =========================
        // TASK 1
        // =========================
        System.out.println("===== TASK 1 =====");

        List<String> task1 = employees.stream()

                // REMOVE managers with salary > 100000 and <=3 yrs exp
                .filter(e -> !(e.getJobTitle().equalsIgnoreCase("manager")
                        && e.getSalary() > 100000
                        && e.getYearsOfExperience() <= 3))

                // Sort: experience DESC, rating ASC
                .sorted(Comparator
                        .comparingInt(Employee::getYearsOfExperience).reversed()
                        .thenComparingInt(Employee::getPerformanceRating))

                // Reverse + uppercase
                .map(e -> new StringBuilder(e.getName())
                        .reverse()
                        .toString()
                        .toUpperCase())

                .toList();

        System.out.println(task1);


        // =========================
        // TASK 2
        // =========================
        System.out.println("\n===== TASK 2 =====");

        List<Integer> task2 = employees.stream()

                // Filter conditions
                .filter(e -> e.getYearsOfExperience() < 5
                        && e.getPerformanceRating() < 8
                        && e.getSalary() >= 60000
                        && e.getSalary() <= 120000)

                // Salary ASC, Experience DESC
                .sorted(Comparator
                        .comparingDouble(Employee::getSalary)
                        .thenComparing(
                                Comparator.comparingInt(Employee::getYearsOfExperience)
                                        .reversed()))

                // ID * 10
                .map(e -> e.getId() * 10)

                .toList();

        System.out.println(task2);


        // =========================
        // TASK 3
        // =========================
        System.out.println("\n===== TASK 3 =====");

        List<Integer> task3 = employees.stream()

                .filter(e -> e.getDepartment().length() > 5
                        && e.getAge() >= 28
                        && e.getAge() <= 45
                        && e.getSalary() < 75000)

                // Rating DESC, Name ASC
                .sorted(Comparator
                        .comparingInt(Employee::getPerformanceRating).reversed()
                        .thenComparing(Employee::getName))

                // ID * 5
                .map(e -> e.getId() * 5)

                .toList();

        System.out.println(task3);
    }
}