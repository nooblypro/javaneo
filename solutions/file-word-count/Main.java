import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine();
        File file = new File("document.txt");
        try (PrintWriter pw = new PrintWriter(file)) {
            for (int i = 0; i < n; i++) {
                pw.println(sc.nextLine());
            }
        }
        int lines = 0;
        int words = 0;
        int chars = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines++;
                chars += line.length() + 1; // +1 for newline
                String trimmed = line.trim();
                if (!trimmed.isEmpty()) {
                    words += trimmed.split("\\s+").length;
                }
            }
        }
        System.out.println("Lines: " + lines);
        System.out.println("Words: " + words);
        System.out.println("Chars: " + chars);
    }
}
