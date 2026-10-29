import java.util.*;

class TaskManager {
    private LinkedList<String> tasks = new LinkedList<>();

    public void processCommand(String command) {
        if (command == null || command.isEmpty()) return;
        String[] parts = command.split(" ", 2);
        String action = parts[0];
        if (action.equals("ADD")) {
            if (parts.length > 1) {
                tasks.addLast(parts[1]);
            }
        } else if (action.equals("REMOVE")) {
            if (!tasks.isEmpty()) {
                tasks.removeFirst();
            }
        } else if (action.equals("SHOW")) {
            if (tasks.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(String.join(" ", tasks));
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline
        TaskManager manager = new TaskManager();
        for (int i = 0; i < n; i++) {
            String command = sc.nextLine();
            manager.processCommand(command);
        }
        sc.close();
    }
}
