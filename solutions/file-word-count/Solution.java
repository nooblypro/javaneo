import java.io.*;
import java.util.*;

class FileStatsAnalyzer {
    public static void countStats(File file) throws Exception {
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
