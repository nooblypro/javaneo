import java.util.*;
public class Main {
    static void validateGrade(int grade) throws IllegalArgumentException {
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        try {
            int g = Integer.parseInt(s);
            validateGrade(g);
            System.out.println("Valid grade: " + g);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
