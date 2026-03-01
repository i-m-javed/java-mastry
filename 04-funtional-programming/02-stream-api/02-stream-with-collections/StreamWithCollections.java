import java.util.*;
import java.util.stream.Collectors;

class Employee {

    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return id + " - " + name + " - " + salary;
    }
}

public class StreamWithCollections{

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Amit", 50000),
                new Employee(2, "Ravi", 60000),
                new Employee(3, "Javed", 70000),
                new Employee(4, "Ankit", 60000),
                new Employee(5, "Ravi", 60000)
        );

        System.out.println("==== FILTERING ====");
        employees.stream()
                .filter(e -> e.getSalary() > 55000)
                .forEach(System.out::println);

        System.out.println("\n==== MAPPING ====");
        List<String> names = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(names);

        System.out.println("\n==== SORTING BY SALARY DESC ====");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .forEach(System.out::println);

        System.out.println("\n==== DISTINCT SALARIES ====");
        employees.stream()
                .map(Employee::getSalary)
                .distinct()
                .forEach(System.out::println);

        System.out.println("\n==== TOTAL SALARY ====");
        double totalSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println(totalSalary);

        System.out.println("\n==== ANY MATCH ====");
        boolean highEarner = employees.stream()
                .anyMatch(e -> e.getSalary() > 80000);
        System.out.println(highEarner);

        System.out.println("\n==== CONVERT TO MAP (ID → NAME) ====");
        Map<Integer, String> idNameMap =
                employees.stream()
                        .collect(Collectors.toMap(
                                Employee::getId,
                                Employee::getName
                        ));
        System.out.println(idNameMap);
    }
}