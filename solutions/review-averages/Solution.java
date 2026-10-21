import java.util.*;

public class Solution {
}

class ProductAnalyzer {
    public void analyzeProductRatings(List<String> lines) {
        System.out.println("Product ID and Average Rating:");
        Map<Integer, List<Double>> ratings = new TreeMap<>();
        for (String line : lines) {
            if (line == null || line.trim().isEmpty()) continue;
            String[] parts = line.trim().split("\\s+");
            if (parts.length >= 2) {
                int id = Integer.parseInt(parts[0]);
                double rating = Double.parseDouble(parts[1]);
                ratings.computeIfAbsent(id, k -> new ArrayList<>()).add(rating);
            }
        }
        for (Map.Entry<Integer, List<Double>> entry : ratings.entrySet()) {
            double sum = 0.0;
            for (double r : entry.getValue()) {
                sum += r;
            }
            double avg = sum / entry.getValue().size();
            System.out.printf(Locale.US, "%d: %.2f\n", entry.getKey(), avg);
        }
    }
}
