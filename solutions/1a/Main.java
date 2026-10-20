import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double p1 = sc.nextDouble(), r1 = sc.nextDouble();
        double p2 = sc.nextDouble(), r2 = sc.nextDouble();
        double i1 = (p1 * r1) / 100.0;
        double i2 = (p2 * r2) / 100.0;
        System.out.printf("Option 1: %.2f\nOption 2: %.2f\n", i1, i2);
    }
}
