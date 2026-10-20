import java.util.*;
public class Main {
    static class InvalidHourException extends Exception {
        public InvalidHourException(String msg) { super(msg); }
    }
    static class InvalidMinuteException extends Exception {
        public InvalidMinuteException(String msg) { super(msg); }
    }
    static class InvalidSecondException extends Exception {
        public InvalidSecondException(String msg) { super(msg); }
    }
    static void validateTime(int h, int m, int s) throws InvalidHourException, InvalidMinuteException, InvalidSecondException {
        if (h < 0 || h > 23) throw new InvalidHourException("Invalid Hour: " + h);
        if (m < 0 || m > 59) throw new InvalidMinuteException("Invalid Minute: " + m);
        if (s < 0 || s > 59) throw new InvalidSecondException("Invalid Second: " + s);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();
        try {
            validateTime(h, m, s);
            System.out.printf("Correct Time - %02d:%02d:%02d\n", h, m, s);
        } catch (InvalidHourException | InvalidMinuteException | InvalidSecondException e) {
            System.out.println(e.getMessage());
        }
    }
}
