import java.util.*;
public class Main {
    static class Employee {
        protected double baseSalary;
        protected double hours;
        Employee(double baseSalary, double hours) {
            this.baseSalary = baseSalary;
            this.hours = hours;
        }
    }
    static class Developer extends Employee {
        Developer(double baseSalary, double hours) { super(baseSalary, hours); }
        double calculateIncome() {
            return baseSalary + (baseSalary * 10.0 * hours / 100.0);
        }
    }
    static class Designer extends Employee {
        Designer(double baseSalary, double hours) { super(baseSalary, hours); }
        double calculateIncome() {
            return baseSalary + (baseSalary * 5.0 * hours / 100.0);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String role = sc.next();
        double base = sc.nextDouble();
        double hours = sc.nextDouble();
        if (role.equalsIgnoreCase("Developer")) {
            Developer dev = new Developer(base, hours);
            System.out.printf("Final Income: %.2f\n", dev.calculateIncome());
        } else if (role.equalsIgnoreCase("Designer")) {
            Designer des = new Designer(base, hours);
            System.out.printf("Final Income: %.2f\n", des.calculateIncome());
        }
    }
}
