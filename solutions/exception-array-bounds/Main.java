import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int q = sc.nextInt();
        try {
            int val = arr[q];
            System.out.println("Value: " + val);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid index " + q);
        }
    }
}
