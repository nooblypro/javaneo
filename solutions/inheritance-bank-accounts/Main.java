import java.util.*;

class Account {
    protected double balance;
    public Account(double balance) { this.balance = balance; }
    public double getBalance() { return balance; }
}

class SavingsAccount extends Account {
    private double rate;
    public SavingsAccount(double balance, double rate) {
        super(balance);
        this.rate = rate;
    }
    public void applyInterest() {
        balance += balance * rate / 100.0;
    }
}

class CheckingAccount extends Account {
    private double limit;
    public CheckingAccount(double balance, double limit) {
        super(balance);
        this.limit = limit;
    }
    public boolean withdraw(double amount) {
        if (amount > balance + limit) {
            return false;
        }
        balance -= amount;
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;
        String type = sc.next();
        if (type.equals("SAVINGS")) {
            double bal = sc.nextDouble();
            double rate = sc.nextDouble();
            SavingsAccount sa = new SavingsAccount(bal, rate);
            sa.applyInterest();
            System.out.printf(Locale.US, "Final Balance: %.2f\n", sa.getBalance());
        } else {
            double bal = sc.nextDouble();
            double limit = sc.nextDouble();
            double amount = sc.nextDouble();
            CheckingAccount ca = new CheckingAccount(bal, limit);
            if (!ca.withdraw(amount)) {
                System.out.println("Overdraft limit exceeded");
            }
            System.out.printf(Locale.US, "Final Balance: %.2f\n", ca.getBalance());
        }
    }
}
