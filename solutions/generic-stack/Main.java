import java.util.*;

class CustomStack<T> {
    private List<T> list = new ArrayList<>();

    public void push(T item) {
        list.add(item);
    }

    public T pop() {
        if (list.isEmpty()) return null;
        return list.remove(list.size() - 1);
    }

    public T peek() {
        if (list.isEmpty()) return null;
        return list.get(list.size() - 1);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine();
        CustomStack<String> stack = new CustomStack<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            if (line.startsWith("PUSH ")) {
                stack.push(line.substring(5).trim());
            } else if (line.equals("POP")) {
                String val = stack.pop();
                System.out.println(val != null ? val : "EMPTY");
            } else if (line.equals("PEEK")) {
                String val = stack.peek();
                System.out.println(val != null ? val : "EMPTY");
            }
        }
    }
}
