import java.util.*;
import java.util.stream.Collectors;

class Employee {

    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return name + " (" + department + ", " + salary + ")";
    }
}

public class CollectorsDemo {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Amit", "IT", 50000),
                new Employee(2, "Ravi", "HR", 60000),
                new Employee(3, "Javed", "IT", 70000),
                new Employee(4, "Ankit", "Finance", 55000),
                new Employee(5, "Neha", "HR", 65000)
        );

        System.out.println("==== GROUPING BY DEPARTMENT ====");
        Map<String, List<Employee>> grouped =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment
                        ));
        System.out.println(grouped);

        System.out.println("\n==== PARTITIONING BY SALARY > 60000 ====");
        Map<Boolean, List<Employee>> partitioned =
                employees.stream()
                        .collect(Collectors.partitioningBy(
                                e -> e.getSalary() > 60000
                        ));
        System.out.println(partitioned);

        System.out.println("\n==== TO MAP (ID → NAME) ====");
        Map<Integer, String> idNameMap =
                employees.stream()
                        .collect(Collectors.toMap(
                                Employee::getId,
                                Employee::getName
                        ));
        System.out.println(idNameMap);

        System.out.println("\n==== JOINING NAMES ====");
        String joinedNames =
                employees.stream()
                        .map(Employee::getName)
                        .collect(Collectors.joining(", "));
        System.out.println(joinedNames);

        System.out.println("\n==== SALARY STATISTICS ====");
        DoubleSummaryStatistics stats =
                employees.stream()
                        .collect(Collectors.summarizingDouble(
                                Employee::getSalary
                        ));
        System.out.println(stats);

        System.out.println("\n==== COUNT EMPLOYEES BY DEPARTMENT ====");
        Map<String, Long> countByDept =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.counting()
                        ));
        System.out.println(countByDept);
    }
}