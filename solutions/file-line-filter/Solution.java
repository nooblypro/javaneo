import java.io.*;
import java.util.*;

class LogFilter {
    public static void filterLogs(File inputFile, File outputFile, String prefix) throws Exception {
        List<String> matched = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(prefix)) {
                    matched.add(line);
                }
            }
        }
        try (PrintWriter pw = new PrintWriter(outputFile)) {
            for (String m : matched) {
                pw.println(m);
            }
        }
    }
}
