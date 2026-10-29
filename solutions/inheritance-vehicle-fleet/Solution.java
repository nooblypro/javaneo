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
