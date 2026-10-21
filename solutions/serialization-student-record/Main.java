import java.io.*;
import java.util.*;

class StudentRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int roll;
    private transient String pin;

    public StudentRecord(String name, int roll, String pin) {
        this.name = name;
        this.roll = roll;
        this.pin = pin;
    }

    public String getName() { return name; }
    public int getRoll() { return roll; }
    public String getPin() { return pin; }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;
        String name = sc.next();
        int roll = sc.nextInt();
        String pin = sc.next();
        StudentRecord rec = new StudentRecord(name, roll, pin);
        File file = new File("student.ser");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(rec);
        }
        StudentRecord loaded;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            loaded = (StudentRecord) ois.readObject();
        }
        System.out.println("Name: " + loaded.getName());
        System.out.println("Roll: " + loaded.getRoll());
        System.out.println("PIN: " + loaded.getPin());
    }
}
