import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int res = a / b;
            System.out.println("Result: " + res);
        } catch (InputMismatchException | ArithmeticException e) {
            System.out.println("Caught exception: " + e.getClass().getSimpleName());
        }
    }
}
