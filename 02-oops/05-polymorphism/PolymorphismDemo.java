class Calculator {

    // Method Overloading
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}

class Animal {

    void sound() {
        System.out.println("Animal makes a sound");
    }

    Animal getInstance() {
        return new Animal();
    }
}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }

    // Covariant return type
    @Override
    Dog getInstance() {
        return new Dog();
    }
}

public class PolymorphismDemo {

    public static void main(String[] args) {

        // Compile-time Polymorphism
        Calculator calc = new Calculator();

        System.out.println("Overloading Examples:");
        System.out.println(calc.add(10, 20));
        System.out.println(calc.add(10.5, 5.5));
        System.out.println(calc.add(1, 2, 3));

        System.out.println("\nRuntime Polymorphism:");

        Animal a = new Animal();
        a.sound();

        Animal d = new Dog();  // Parent reference, Child object
        d.sound();             // Dynamic Method Dispatch

        System.out.println("\nCovariant Return Type Example:");
        Animal obj = new Dog();
        obj.getInstance();
    }
}