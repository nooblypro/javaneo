import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) arr1[i] = sc.nextInt();
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) arr2[i] = sc.nextInt();

        int[] merged = new int[n + m];
        long total = 0;
        for (int i = 0; i < n; i++) {
            merged[i] = arr1[i];
            total += arr1[i];
        }
        for (int i = 0; i < m; i++) {
            merged[n + i] = arr2[i];
            total += arr2[i];
        }

        System.out.print("Merged steps:");
        for (int step : merged) {
            System.out.print(" " + step);
        }
        System.out.println();
        System.out.println("Total Distance: " + total);
    }
}
