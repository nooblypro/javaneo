import java.util.*;

class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() { return first; }
    public U getSecond() { return second; }

    public Pair<U, T> swap() {
        return new Pair<>(second, first);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;
        String s = sc.next();
        int num = sc.nextInt();
        Pair<String, Integer> p = new Pair<>(s, num);
        System.out.println("Original: (" + p.getFirst() + ", " + p.getSecond() + ")");
        Pair<Integer, String> swapped = p.swap();
        System.out.println("Swapped: (" + swapped.getFirst() + ", " + swapped.getSecond() + ")");
    }
}
