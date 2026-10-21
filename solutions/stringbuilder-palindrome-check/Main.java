import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        String line = sc.nextLine();
        StringBuilder cleaned = new StringBuilder();
        for (char c : line.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(Character.toLowerCase(c));
            }
        }
        String cleanStr = cleaned.toString();
        String revStr = new StringBuilder(cleanStr).reverse().toString();
        boolean isPal = cleanStr.equals(revStr);
        System.out.println("Cleaned: " + cleanStr);
        System.out.println("Result: " + (isPal ? "Palindrome" : "Not a palindrome"));
    }
}
