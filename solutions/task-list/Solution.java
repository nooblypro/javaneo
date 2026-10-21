import java.util.*;

public class Solution {
    // helper class can also just be TaskManager in same file or TaskManager class
}

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
