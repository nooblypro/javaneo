import java.util.*;

public class Main {
    private static final Object lock = new Object();
    private static int current = 1;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        Thread odd = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (current > n) {
                        lock.notifyAll();
                        break;
                    }
                    if (current % 2 != 0) {
                        System.out.println(current);
                        current++;
                        lock.notifyAll();
                    } else {
                        try { lock.wait(); } catch (InterruptedException e) {}
                    }
                }
            }
        });

        Thread even = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (current > n) {
                        lock.notifyAll();
                        break;
                    }
                    if (current % 2 == 0) {
                        System.out.println(current);
                        current++;
                        lock.notifyAll();
                    } else {
                        try { lock.wait(); } catch (InterruptedException e) {}
                    }
                }
            }
        });

        odd.start();
        even.start();
        odd.join();
        even.join();
    }
}
