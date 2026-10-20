import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        FileWriter fw = new FileWriter("input.txt");
        fw.write(line);
        fw.close();

        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String readText = br.readLine();
        br.close();

        Set<String> posWords = new HashSet<>(Arrays.asList("happy", "good", "excellent", "positive"));
        Set<String> negWords = new HashSet<>(Arrays.asList("sad", "bad", "terrible", "negative"));

        int pos = 0, neg = 0;
        if (readText != null) {
            String[] tokens = readText.toLowerCase().split("[^a-z0-9]+");
            for (String t : tokens) {
                if (posWords.contains(t)) pos++;
                if (negWords.contains(t)) neg++;
            }
        }
        String result = "neutral";
        if (pos > neg) result = "positive";
        else if (neg > pos) result = "negative";

        FileWriter outFw = new FileWriter("output.txt");
        outFw.write(result);
        outFw.close();

        System.out.println(result);
    }
}
