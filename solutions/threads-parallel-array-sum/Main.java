import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        int mid = n / 2;
        final long[] sum1 = new long[1];
        final long[] sum2 = new long[1];

        Thread t1 = new Thread(() -> {
            long s = 0;
            for (int i = 0; i < mid; i++) s += arr[i];
            sum1[0] = s;
        });

        Thread t2 = new Thread(() -> {
            long s = 0;
            for (int i = mid; i < n; i++) s += arr[i];
            sum2[0] = s;
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        long total = sum1[0] + sum2[0];
        System.out.println("Half 1: " + sum1[0]);
        System.out.println("Half 2: " + sum2[0]);
        System.out.println("Total: " + total);
    }
}
