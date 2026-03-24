class Student {

    String name;                 // Instance variable
    int rollNumber;              // Instance variable

    static String schoolName;    // Static variable (shared)
    static int studentCount;     // Static counter

    // Static block
    static {
        schoolName = "ABC Public School";
        studentCount = 0;
        System.out.println("Static block executed");
    }

    // Constructor
    Student(String name) {
        this.name = name;
        studentCount++;   // shared counter
        rollNumber = studentCount;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll: " + rollNumber);
        System.out.println("School: " + schoolName);
        System.out.println("-------------------");
    }

    // Static method
    static void changeSchool(String newSchool) {
        schoolName = newSchool;
    }

    // Static nested class
    static class Helper {
        static void info() {
            System.out.println("Helper class inside Student");
        }
    }
}

public class StaticDemo {

    public static void main(String[] args) {

        System.out.println("Creating First Student:");
        Student s1 = new Student("Javed");

        System.out.println("\nCreating Second Student:");
        Student s2 = new Student("Rahul");

        s1.display();
        s2.display();

        System.out.println("Total Students: " + Student.studentCount);

        System.out.println("\nChanging School Name:");
        Student.changeSchool("XYZ International");

        s1.display();
        s2.display();

        System.out.println("\nUsing Static Nested Class:");
        Student.Helper.info();
    }
}