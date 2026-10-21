import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLine());
        }
        list.sort((a, b) -> {
            if (a.length() != b.length()) {
                return Integer.compare(a.length(), b.length());
            }
            return a.compareTo(b);
        });
        for (String s : list) {
            System.out.println(s);
        }
    }
}
