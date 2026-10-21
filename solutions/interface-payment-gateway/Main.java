import java.util.*;

interface PaymentProcessor {
    double processPayment(double amount);
}

class CreditCardProcessor implements PaymentProcessor {
    public double processPayment(double amount) {
        return amount * 1.025;
    }
}

class CryptoProcessor implements PaymentProcessor {
    public double processPayment(double amount) {
        return amount + 5.00;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;
        String type = sc.next();
        double amount = sc.nextDouble();
        PaymentProcessor p = type.equals("CREDIT") ? new CreditCardProcessor() : new CryptoProcessor();
        System.out.printf(Locale.US, "Charged: $%.2f\n", p.processPayment(amount));
    }
}
