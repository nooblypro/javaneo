import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine();
        Map<String, String> dir = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            if (line.startsWith("ADD ")) {
                String[] parts = line.substring(4).split("\\s+");
                dir.put(parts[0], parts[1]);
            } else if (line.startsWith("FIND ")) {
                String name = line.substring(5).trim();
                if (dir.containsKey(name)) {
                    System.out.println(name + ": " + dir.get(name));
                } else {
                    System.out.println("Not found: " + name);
                }
            }
        }
    }
}
