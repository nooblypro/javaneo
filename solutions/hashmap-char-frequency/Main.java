import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        String line = sc.nextLine();
        Map<Character, Integer> map = new TreeMap<>();
        for (char c : line.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        if (map.isEmpty()) {
            System.out.println("None");
        } else {
            for (Map.Entry<Character, Integer> e : map.entrySet()) {
                System.out.println(e.getKey() + ": " + e.getValue());
            }
        }
    }
}
