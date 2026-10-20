import java.util.*;
public class Main {
    static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        List<Integer> primes = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) primes.add(i);
        }
        if (primes.isEmpty()) {
            System.out.println("No primes found");
        } else {
            for (int i = 0; i < primes.size(); i++) {
                if (i > 0) System.out.print(" ");
                System.out.print(primes.get(i));
            }
            System.out.println();
        }
    }
}
