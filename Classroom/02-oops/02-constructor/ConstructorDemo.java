class Employee {

    String name;
    int age;
    double salary;

    // 1️⃣ Default constructor
    Employee() {
        this("Unknown", 0, 0.0);   // Constructor chaining
        System.out.println("Default Constructor Called");
    }

    // 2️⃣ Parameterized constructor
    Employee(String name, int age) {
        this(name, age, 0.0);      // Constructor chaining
        System.out.println("Two-Parameter Constructor Called");
    }

    // 3️⃣ Main constructor
    Employee(String name, int age, double salary) {
        this.name = name;   // using this keyword
        this.age = age;
        this.salary = salary;
        System.out.println("Three-Parameter Constructor Called");
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
        System.out.println("------------------------");
    }
}

public class ConstructorDemo {

    public static void main(String[] args) {

        System.out.println("Creating Object 1:");
        Employee e1 = new Employee();

        System.out.println("\nCreating Object 2:");
        Employee e2 = new Employee("Javed", 22);

        System.out.println("\nCreating Object 3:");
        Employee e3 = new Employee("Rahul", 25, 50000);

        System.out.println("\nDisplaying Details:");
        e1.display();
        e2.display();
        e3.display();
    }
}