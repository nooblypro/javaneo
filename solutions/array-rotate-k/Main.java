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
        int k = sc.nextInt();
        k = k % n;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[(i + k) % n] = arr[i];
        }
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + (i < n - 1 ? " " : "\n"));
        }
    }
}
