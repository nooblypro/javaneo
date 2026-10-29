class NumberPrinter {
    private final Object lock = new Object();
    private int current = 1;

    public void printNumbers(int n) throws Exception {
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
