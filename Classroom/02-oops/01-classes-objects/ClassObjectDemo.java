class Student {

    // Instance Variables
    String name;
    int age;
    double marks;

    // Method to assign values
    void setDetails(String n, int a, double m) {
        name = n;
        age = a;
        marks = m;
    }

    // Method to display details
    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Marks: " + marks);
        System.out.println("----------------------");
    }

    // Method demonstrating local variable
    void calculateGrade() {
        String grade;  // local variable

        if (marks >= 90)
            grade = "A";
        else if (marks >= 75)
            grade = "B";
        else if (marks >= 50)
            grade = "C";
        else
            grade = "Fail";

        System.out.println(name + " Grade: " + grade);
    }
}

public class ClassObjectDemo {

    public static void main(String[] args) {

        // Creating first object
        Student s1 = new Student();
        s1.setDetails("Javed", 22, 88.5);

        // Creating second object
        Student s2 = new Student();
        s2.setDetails("Rahul", 21, 65.0);

        // Display details
        s1.displayDetails();
        s2.displayDetails();

        // Calculate grades
        s1.calculateGrade();
        s2.calculateGrade();

        // Modifying one object
        s1.marks = 95;

        System.out.println("\nAfter modifying s1 marks:");
        s1.displayDetails();
        s2.displayDetails();  // unchanged (object independence)
    }
}