import java.io.*;
import java.util.*;
public class Main {
    static class BankAccount implements Serializable {
        private static final long serialVersionUID = 1L;
        private double balance;
        BankAccount(double init) { this.balance = init; }
        void deposit(double amt) { this.balance += amt; }
        void withdraw(double amt) { this.balance -= amt; }
        double getBalance() { return balance; }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        double init = sc.nextDouble();
        double dep = sc.nextDouble();
        double w = sc.nextDouble();

        BankAccount acc = new BankAccount(init);
        acc.deposit(dep);
        acc.withdraw(w);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("bankAccount.ser"))) {
            oos.writeObject(acc);
        }

        BankAccount deserialized;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("bankAccount.ser"))) {
            deserialized = (BankAccount) ois.readObject();
        }

        System.out.printf("%.2f\n", deserialized.getBalance());
    }
}
