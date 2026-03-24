// Parent Class
class Person {

    private String ssn;           // private - only within this class
    String name;                  // default - within same package
    protected int age;            // protected - same package + subclass
    public String country;        // public - everywhere

    // Constructor
    public Person(String ssn, String name, int age, String country) {
        this.ssn = ssn;
        this.name = name;
        this.age = age;
        this.country = country;
    }

    // Getter for private variable
    public String getSSN() {
        return ssn;
    }

    // Method inside same class can access all variables
    public void display() {
        System.out.println("SSN: " + ssn);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Country: " + country);
    }
}

// Child class
class Employee extends Person {

    public Employee(String ssn, String name, int age, String country) {
        super(ssn, name, age, country);
    }

    public void showAccess() {
        // System.out.println(ssn); ❌ Not accessible (private)
        System.out.println("Name: " + name);        // default
        System.out.println("Age: " + age);          // protected
        System.out.println("Country: " + country);  // public
    }
}

public class AccessModifierDemo {

    public static void main(String[] args) {

        Person p = new Person("123-45-6789", "Javed", 22, "India");

        System.out.println("Accessing from Main:");

        // System.out.println(p.ssn); ❌ private - not accessible
        System.out.println(p.name);     // default (same package)
        System.out.println(p.age);      // protected (same package)
        System.out.println(p.country);  // public

        System.out.println("\nUsing Getter for Private:");
        System.out.println(p.getSSN());

        System.out.println("\nInheritance Access:");
        Employee e = new Employee("987-65-4321", "Rahul", 25, "India");
        e.showAccess();
    }
}