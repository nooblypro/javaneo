import java.util.*;

class Box<T> {
    private T item;
    public Box(T item) { this.item = item; }
    public boolean contains(T other) {
        return item != null && item.equals(other);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;
        String type = sc.next();
        String targetStr = sc.next();
        int n = sc.nextInt();
        int count = 0;
        if (type.equals("INT")) {
            int target = Integer.parseInt(targetStr);
            for (int i = 0; i < n; i++) {
                Box<Integer> box = new Box<>(sc.nextInt());
                if (box.contains(target)) count++;
            }
        } else {
            for (int i = 0; i < n; i++) {
                Box<String> box = new Box<>(sc.next());
                if (box.contains(targetStr)) count++;
            }
        }
        System.out.println("Matches: " + count);
    }
}
