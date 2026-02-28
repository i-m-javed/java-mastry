class Person {

    String name;

    Person(String name) {
        this.name = name;
        System.out.println("Person Constructor Called");
    }

    void display() {
        System.out.println("Name: " + name);
    }
}

class Employee extends Person {

    double salary;

    Employee(String name, double salary) {
        super(name);  // calling parent constructor
        this.salary = salary;
        System.out.println("Employee Constructor Called");
    }

    void display() {
        super.display();  // calling parent method
        System.out.println("Salary: " + salary);
    }
}

class Manager extends Employee {

    String department;

    Manager(String name, double salary, String department) {
        super(name, salary);
        this.department = department;
        System.out.println("Manager Constructor Called");
    }

    void display() {
        super.display();
        System.out.println("Department: " + department);
    }
}

public class InheritanceDemo {

    public static void main(String[] args) {

        System.out.println("Creating Manager Object:\n");

        Manager m = new Manager("Javed", 75000, "IT");

        System.out.println("\nDisplaying Details:\n");
        m.display();

        System.out.println("\nPolymorphic Reference:\n");

        Person p = new Manager("Rahul", 80000, "HR");
        p.display();  // runtime method call
    }
}