import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        String prefix = sc.nextLine();
        int n = Integer.parseInt(sc.nextLine());
        File allFile = new File("all_logs.txt");
        try (PrintWriter pw = new PrintWriter(allFile)) {
            for (int i = 0; i < n; i++) {
                pw.println(sc.nextLine());
            }
        }
        List<String> matched = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(allFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(prefix)) {
                    matched.add(line);
                }
            }
        }
        File filteredFile = new File("filtered_logs.txt");
        try (PrintWriter pw = new PrintWriter(filteredFile)) {
            for (String m : matched) {
                pw.println(m);
            }
        }
        System.out.println("Matched lines: " + matched.size());
        for (String m : matched) {
            System.out.println(m);
        }
    }
}
