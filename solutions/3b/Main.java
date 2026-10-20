import java.util.*;
public class Main {
    static class ArrayConcatenator {
        int[] result;
        ArrayConcatenator(int[] a, int[] b) {
            result = new int[a.length + b.length];
            System.arraycopy(a, 0, result, 0, a.length);
            System.arraycopy(b, 0, result, a.length, b.length);
        }
        void printConcatenated() {
            for (int i = 0; i < result.length; i++) {
                if (i > 0) System.out.print(" ");
                System.out.print(result[i]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        int m = sc.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) b[i] = sc.nextInt();
        ArrayConcatenator ac = new ArrayConcatenator(a, b);
        ac.printConcatenated();
    }
}
