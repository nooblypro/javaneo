import java.util.*;
public class Main {
    static interface Motor {
        void run();
        void consume();
        double consume(double capacity);
    }
    static class WashingMachine implements Motor {
        public void run() {
            System.out.println("Washing machine is running.");
        }
        public void consume() {
            System.out.println("Washing machine is consuming electricity.");
        }
        public double consume(double capacity) {
            return capacity * 0.05;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double cap = sc.nextDouble();
        Motor m = new WashingMachine();
        m.run();
        m.consume();
        System.out.printf("Consumption: %.2f\n", m.consume(cap));
    }
}
