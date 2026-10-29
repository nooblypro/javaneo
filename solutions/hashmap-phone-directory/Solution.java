import java.util.*;

class PhoneDirectory {
    private Map<String, String> dir = new HashMap<>();

    public void addContact(String name, String phone) {
        dir.put(name, phone);
    }

    public void findContact(String name) {
        if (dir.containsKey(name)) {
            System.out.println(name + ": " + dir.get(name));
        } else {
            System.out.println("Not found: " + name);
        }
    }
}
