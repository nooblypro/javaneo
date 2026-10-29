import java.util.Locale;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String msg) {
        super(msg);
    }
}

class BankAccount {
    public static void withdraw(double balance, double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds: balance is " + balance + ", attempted " + amount);
        }
        double remaining = balance - amount;
        System.out.printf(Locale.US, "Remaining balance: %.2f\n", remaining);
    }
}
