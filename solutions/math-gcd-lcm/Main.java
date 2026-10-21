import java.util.*;

public class Main {
    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLong()) return;
        long a = sc.nextLong();
        long b = sc.nextLong();
        long g = gcd(a, b);
        long l = (a / g) * b;
        System.out.println("GCD: " + g);
        System.out.println("LCM: " + l);
    }
}
