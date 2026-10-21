import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextDouble()) return;
        double p = sc.nextDouble();
        double r = sc.nextDouble();
        int t = sc.nextInt();
        double amount = p * Math.pow(1.0 + r / 100.0, t);
        double interest = amount - p;
        System.out.printf(Locale.US, "Amount: %.2f\n", amount);
        System.out.printf(Locale.US, "Interest: %.2f\n", interest);
    }
}
