import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(sc.next());
        int idx = sc.nextInt();
        if (idx >= 0 && idx < list.size()) {
            System.out.println("Student: " + list.get(idx));
        } else {
            System.out.println("Index out of bounds: " + idx);
        }
    }
}
