import java.util.*;

public class StudentTask {

    // ============================
    // Student Class
    // ============================
    static class Student {
        private int id;
        private String name;
        private String course;
        private int age;
        private double marks;
        private int yearOfStudy;
        private String city;

        public Student(int id, String name, String course,
                       int age, double marks,
                       int yearOfStudy, String city) {
            this.id = id;
            this.name = name;
            this.course = course;
            this.age = age;
            this.marks = marks;
            this.yearOfStudy = yearOfStudy;
            this.city = city;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public String getCourse() { return course; }
        public int getAge() { return age; }
        public double getMarks() { return marks; }
        public int getYearOfStudy() { return yearOfStudy; }
        public String getCity() { return city; }

        @Override
        public String toString() {
            return name + " (" + marks + ")";
        }
    }

    // ============================
    // Add Students Method
    // ============================
    public static List<Student> addStudents() {

        return List.of(
                new Student(1, "Ali", "BCA", 20, 82.5, 2, "Delhi"),
                new Student(2, "Sara", "BTech", 21, 91.0, 3, "Mumbai"),
                new Student(3, "John", "BCA", 19, 65.0, 1, "Delhi"),
                new Student(4, "Ayesha", "MBA", 23, 88.5, 2, "Pune"),
                new Student(5, "David", "BTech", 22, 72.0, 4, "Bangalore"),
                new Student(6, "Fatima", "BCA", 20, 95.0, 3, "Delhi"),
                new Student(7, "Michael", "MBA", 24, 55.0, 1, "Mumbai"),
                new Student(8, "Zara", "BTech", 21, 78.0, 2, "Pune"),
                new Student(9, "Ahmed", "BCA", 20, 88.5, 2, "Delhi"),
                new Student(10, "Emma", "MBA", 23, 92.0, 3, "Bangalore"),
                new Student(11, "Noah", "BSc", 19, 69.0, 1, "Chennai"),
                new Student(12, "Olivia", "BSc", 20, 85.0, 2, "Chennai"),
                new Student(13, "Liam", "BTech", 22, 40.0, 4, "Hyderabad"),
                new Student(14, "Sophia", "MBA", 24, 97.0, 2, "Delhi"),
                new Student(15, "Arjun", "BCA", 21, 75.0, 3, "Kolkata")
        );
    }

    // ============================
    // MAIN
    // ============================
    public static void main(String[] args) {

        List<Student> students = addStudents();

        // -------------------------
        // TASK 1
        // -------------------------
        System.out.println("===== TASK 1 =====");

        List<String> task1 = students.stream()

                // Filter: BCA, marks > 75, year <= 2
                .filter(s -> s.getCourse().equals("BCA")
                        && s.getMarks() > 75
                        && s.getYearOfStudy() <= 2)

                // Sort: marks DESC, age ASC
                .sorted(Comparator
                        .comparing(Student::getMarks).reversed()
                        .thenComparing(Student::getAge))

                // Convert name to lowercase
                .map(s -> s.getName().toLowerCase())

                .toList();

        System.out.println(task1);


        // -------------------------
        // TASK 2
        // -------------------------
        System.out.println("\n===== TASK 2 =====");

        List<String> task2 = students.stream()

                // Filter city starts with M, marks 60-90, age > 20
                .filter(s -> s.getCity().startsWith("M")
                        && s.getMarks() >= 60
                        && s.getMarks() <= 90
                        && s.getAge() > 20)

                // Sort year ASC, marks DESC
                .sorted(Comparator
                        .comparing(Student::getYearOfStudy)
                        .thenComparing(Comparator
                                .comparing(Student::getMarks)
                                .reversed()))

                // Convert ID to String
                .map(s -> String.valueOf(s.getId()))

                .toList();

        System.out.println(task2);


        // -------------------------
        // TASK 3
        // -------------------------
        System.out.println("\n===== TASK 3 =====");

        List<String> task3 = students.stream()

                // Filter: final year (4), marks < 65
                .filter(s -> s.getYearOfStudy() == 4
                        && s.getMarks() < 65)

                // Sort age DESC, city ASC
                .sorted(Comparator
                        .comparing(Student::getAge).reversed()
                        .thenComparing(Student::getCity))

                // Reverse student name
                .map(s -> new StringBuilder(s.getName())
                        .reverse()
                        .toString())

                .toList();

        System.out.println(task3);
    }
}