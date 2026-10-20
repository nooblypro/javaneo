import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        Map<String, List<Double>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String city = sc.next();
            double temp = sc.nextDouble();
            map.computeIfAbsent(city, k -> new ArrayList<>()).add(temp);
        }

        List<String> cities = new ArrayList<>(map.keySet());
        Collections.sort(cities);

        for (String city : cities) {
            List<Double> temps = map.get(city);
            Collections.sort(temps);
            double median;
            int size = temps.size();
            if (size % 2 == 1) {
                median = temps.get(size / 2);
            } else {
                median = (temps.get(size / 2 - 1) + temps.get(size / 2)) / 2.0;
            }
            System.out.printf("%s: %.2f\n", city, median);
        }
    }
}
