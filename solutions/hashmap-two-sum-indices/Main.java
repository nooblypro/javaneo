import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int target = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Map<Integer, Integer> map = new HashMap<>();
        boolean found = false;
        for (int i = 0; i < n; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                System.out.println("Indices: " + map.get(complement) + " " + i);
                found = true;
                break;
            }
            map.put(arr[i], i);
        }
        if (!found) {
            System.out.println("No pair found");
        }
    }
}
