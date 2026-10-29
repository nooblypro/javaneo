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
