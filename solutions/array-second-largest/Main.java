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
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for (int x : arr) set.add(x);
        if (set.size() < 2) {
            System.out.println("No second largest");
        } else {
            Iterator<Integer> it = set.iterator();
            it.next(); // largest
            System.out.println("Second largest: " + it.next());
        }
    }
}
