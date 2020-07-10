package dbelousov.petprojects.challenges.arraysandstrings;

import java.util.HashMap;

public class IsUnique {

    // Using HashMap
    public static boolean isUniqueWithHashMap(String s) {
        if (s == null || s.equals("")) return false;
        HashMap<Character, Integer> frequency = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (frequency.put(ch, 1) != null) {
                return false;
            }
        }
        return true;
    }

    // Using array
    public static boolean isUniqueWithArray(String s) {
        if (s == null || s.equals("")) return false;
        int stringLength = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < stringLength - 1; i++) {
            for (int j = i + 1; j < stringLength; j++) {
                if (chars[i] == chars[j]) return false;
            }
        }
        return true;
    }
}
