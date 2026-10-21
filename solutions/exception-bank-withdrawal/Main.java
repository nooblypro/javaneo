import java.util.*;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String msg) {
        super(msg);
    }
}

public class Main {
    static void withdraw(double balance, double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds: balance is " + balance + ", attempted " + amount);
        }
        double remaining = balance - amount;
        System.out.printf(Locale.US, "Remaining balance: %.2f\n", remaining);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextDouble()) return;
        double balance = sc.nextDouble();
        double amount = sc.nextDouble();
        try {
            withdraw(balance, amount);
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
