import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PrintWriter pw = new PrintWriter(new FileWriter("prices.txt"));
        for (int i = 0; i < n; i++) pw.print(sc.nextDouble() + " ");
        pw.close();

        Scanner fileSc = new Scanner(new File("prices.txt"));
        List<Double> taxed = new ArrayList<>();
        while (fileSc.hasNextDouble()) {
            taxed.add(fileSc.nextDouble() * 1.10);
        }
        fileSc.close();

        PrintWriter taxPw = new PrintWriter(new FileWriter("tax.txt"));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < taxed.size(); i++) {
            String val = String.format("%.2f", taxed.get(i));
            taxPw.print(val + " ");
            if (i > 0) sb.append(" ");
            sb.append(val);
        }
        taxPw.close();
        System.out.println(sb.toString());
    }
}
