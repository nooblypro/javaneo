import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Math.abs(sc.nextInt());
        int d1 = n / 100;
        int d2 = (n / 10) % 10;
        int d3 = n % 10;
        int sum = d1 + d2 + d3;
        System.out.println("Sum of digits: " + sum);
        System.out.println(sum % 2 == 0 ? "Even" : "Odd");
    }
}
