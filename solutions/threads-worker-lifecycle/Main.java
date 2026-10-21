import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int delay = sc.nextInt();
        Thread worker = new Thread(() -> {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {}
        });
        System.out.println("Initial: " + worker.getState());
        worker.start();
        worker.join();
        System.out.println("Final: " + worker.getState());
    }
}
