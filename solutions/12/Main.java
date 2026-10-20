import java.io.*;
import java.util.*;
public class Main {
    static class SavingsData implements Serializable {
        private static final long serialVersionUID = 1L;
        private double salary, savings;
        SavingsData(double salary, double savings) {
            this.salary = salary;
            this.savings = savings;
        }
        String getCategory() {
            if (salary <= 0 || savings < 0) return "Invalid input";
            double pct = (savings / salary) * 100.0;
            if (pct < 1.0) return "Invalid input";
            if (pct <= 10.0) return "Poor";
            if (pct < 20.0) return "Good";
            return "High";
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        double sal = sc.nextDouble();
        double sav = sc.nextDouble();
        SavingsData data = new SavingsData(sal, sav);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("savings.ser"))) {
            oos.writeObject(data);
        }

        SavingsData deserialized;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("savings.ser"))) {
            deserialized = (SavingsData) ois.readObject();
        }

        System.out.println(deserialized.getCategory());
    }
}
