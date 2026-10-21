import java.util.*;

abstract class Shape {
    public abstract double area();
    public abstract double perimeter();
}

class Circle extends Shape {
    private double radius;
    public Circle(double radius) { this.radius = radius; }
    public double area() { return Math.PI * radius * radius; }
    public double perimeter() { return 2 * Math.PI * radius; }
}

class Rectangle extends Shape {
    private double width, height;
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public double area() { return width * height; }
    public double perimeter() { return 2 * (width + height); }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;
        String type = sc.next();
        Shape s;
        if (type.equals("CIRCLE")) {
            s = new Circle(sc.nextDouble());
        } else {
            s = new Rectangle(sc.nextDouble(), sc.nextDouble());
        }
        System.out.printf(Locale.US, "Area: %.2f\n", s.area());
        System.out.printf(Locale.US, "Perimeter: %.2f\n", s.perimeter());
    }
}
