import java.util.*;

interface StringTransformer {
    String transform(String input);
}

class UpperTransformer implements StringTransformer {
    public String transform(String input) { return input.toUpperCase(); }
}

class ReverseTransformer implements StringTransformer {
    public String transform(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}

class TrimTransformer implements StringTransformer {
    public String transform(String input) { return input.trim(); }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        String choice = sc.nextLine().trim();
        String text = sc.nextLine();
        StringTransformer st;
        if (choice.equals("UPPER")) st = new UpperTransformer();
        else if (choice.equals("REVERSE")) st = new ReverseTransformer();
        else st = new TrimTransformer();
        System.out.println(st.transform(text));
    }
}
