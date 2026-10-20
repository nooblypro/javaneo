import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        double kmh = sc.nextDouble();
        PrintWriter pw = new PrintWriter(new FileWriter("data.txt"));
        pw.println(kmh);
        pw.close();

        Scanner fileSc = new Scanner(new File("data.txt"));
        double val = fileSc.nextDouble();
        fileSc.close();

        double ms = val / 3.6;
        PrintWriter outPw = new PrintWriter(new FileWriter("converted.txt"));
        outPw.printf("%.2f\n", ms);
        outPw.close();

        System.out.printf("%.2f\n", ms);
    }
}
