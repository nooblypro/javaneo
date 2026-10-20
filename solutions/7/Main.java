import java.util.*;
public class Main {
    static class MessageBuffer {
        private String msg;
        private boolean empty = true;
        synchronized void put(String m) {
            while (!empty) {
                try { wait(); } catch (InterruptedException e) {}
            }
            this.msg = m;
            empty = false;
            notify();
        }
        synchronized String take() {
            while (empty) {
                try { wait(); } catch (InterruptedException e) {}
            }
            empty = true;
            notify();
            return msg;
        }
    }

    static class Producer implements Runnable {
        private MessageBuffer buffer;
        private int count;
        Producer(MessageBuffer buffer, int count) {
            this.buffer = buffer;
            this.count = count;
        }
        public void run() {
            for (int i = 1; i <= count; i++) {
                buffer.put("Message " + i);
            }
        }
    }

    static class Consumer implements Runnable {
        private MessageBuffer buffer;
        private int count;
        Consumer(MessageBuffer buffer, int count) {
            this.buffer = buffer;
            this.count = count;
        }
        public void run() {
            for (int i = 1; i <= count; i++) {
                System.out.println(buffer.take());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.hasNextInt() ? sc.nextInt() : 5;
        MessageBuffer buf = new MessageBuffer();
        Thread prod = new Thread(new Producer(buf, n));
        Thread cons = new Thread(new Consumer(buf, n));
        prod.start();
        cons.start();
        prod.join();
        cons.join();
    }
}
