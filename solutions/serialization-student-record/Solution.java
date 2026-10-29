import java.io.Serializable;

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
