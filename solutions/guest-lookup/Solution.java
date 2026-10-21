import java.util.*;

public class Solution {
}

class NameManager {
    private List<String> names = new ArrayList<>();

    public void addName(String name) {
        names.add(name);
    }

    public void printNameAtIndex(int index) {
        if (index >= 0 && index < names.size()) {
            System.out.println("Element at index " + index + ": " + names.get(index));
        } else {
            System.out.println("Invalid index");
        }
    }
}
