import java.util.*;

class Vehicle {
    protected String model;
    protected double baseRatePerDay;

    public Vehicle(String model, double baseRatePerDay) {
        this.model = model;
        this.baseRatePerDay = baseRatePerDay;
    }

    public double calculateTotal(int days) {
        return baseRatePerDay * days;
    }

    public String getModel() { return model; }
}

class Car extends Vehicle {
    public Car(String model, double baseRatePerDay) {
        super(model, baseRatePerDay);
    }

    @Override
    public double calculateTotal(int days) {
        return super.calculateTotal(days) + 15.0;
    }
}

class Truck extends Vehicle {
    public Truck(String model, double baseRatePerDay) {
        super(model, baseRatePerDay);
    }

    @Override
    public double calculateTotal(int days) {
        return (baseRatePerDay + 25.0) * days;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;
        String type = sc.next();
        String model = sc.next();
        double rate = sc.nextDouble();
        int days = sc.nextInt();
        Vehicle v = type.equals("CAR") ? new Car(model, rate) : new Truck(model, rate);
        System.out.println("Model: " + v.getModel());
        System.out.printf(Locale.US, "Total: $%.2f\n", v.calculateTotal(days));
    }
}
