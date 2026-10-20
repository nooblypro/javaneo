import java.util.*;
public class Main {
    static class Rectangle {
        int length, breadth;
        Rectangle(int length, int breadth) {
            this.length = length;
            this.breadth = breadth;
        }
        int area() { return length * breadth; }
        int perimeter() { return 2 * (length + breadth); }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int b = sc.nextInt();
        Rectangle rect = new Rectangle(l, b);
        System.out.println("Area: " + rect.area());
        System.out.println("Perimeter: " + rect.perimeter());
    }
}
