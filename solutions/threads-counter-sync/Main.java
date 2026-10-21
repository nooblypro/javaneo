import java.util.*;

class Counter {
    private int count = 0;
    public synchronized void add(int v) {
        count += v;
    }
    public int get() { return count; }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        Counter counter = new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < n; i++) counter.add(1);
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < n; i++) counter.add(2);
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Final count: " + counter.get());
    }
}
