import java.util.*;

public class Solution {
}

class NameCounter {
    public int count(ArrayList<String> names, String target) {
        if (names == null || target == null) return 0;
        int count = 0;
        for (String name : names) {
            if (target.equals(name)) {
                count++;
            }
        }
        return count;
    }
}
