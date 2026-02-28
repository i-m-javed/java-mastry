// Abstract Class
abstract class Shape {

    String color;

    // Constructor in abstract class
    Shape(String color) {
        this.color = color;
        System.out.println("Shape constructor called");
    }

    // Abstract method
    abstract double area();

    // Concrete method
    void displayColor() {
        System.out.println("Color: " + color);
    }
}

// Interface
interface Printable {
    void print();
}

interface Resizable {
    void resize(double factor);
}

// Concrete class extending abstract class and implementing interfaces
class Circle extends Shape implements Printable, Resizable {

    double radius;

    Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public void print() {
        System.out.println("Circle area: " + area());
    }

    @Override
    public void resize(double factor) {
        radius = radius * factor;
        System.out.println("Resized radius: " + radius);
    }
}

public class AbstractionDemo {

    public static void main(String[] args) {

        // Runtime polymorphism
        Shape shape = new Circle("Red", 5);

        shape.displayColor();
        System.out.println("Area: " + shape.area());

        System.out.println("\nUsing Interface Methods:");

        Printable printable = new Circle("Blue", 3);
        printable.print();

        Resizable resizable = new Circle("Green", 4);
        resizable.resize(2);
    }
}