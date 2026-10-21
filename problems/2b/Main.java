import java.util.*;

public class Main {
    public static boolean isPrime(int n) {
        if (n <= 1) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();
        boolean found = false;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int n = sc.nextInt();

                if (isPrime(n)) {
                    System.out.println("Prime " + n + " at (" + i + ", " + j + ")");
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No primes found");
        }

        sc.close();
    }
}