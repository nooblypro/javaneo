import java.util.*;

public class Main {
    public static <T extends Comparable<T>> T findMax(T[] array) {
        if (array == null || array.length == 0) return null;
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;
        String type = sc.next();
        int n = sc.nextInt();
        if (type.equals("INTEGER")) {
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
            System.out.println("Max: " + findMax(arr));
        } else {
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) arr[i] = sc.next();
            System.out.println("Max: " + findMax(arr));
        }
    }
}
