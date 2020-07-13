package dbelousov.petprojects.challenges.arraysandstrings;

import java.util.HashMap;

public class IsPermutation {

    public static boolean isPermutation(String s1, String s2) {
        if (s1 == null || s1.equals("") || s2 == null || s2.equals("")
                || s1.length() != s2.length())
            return false;
        HashMap<Character, Integer> frequency1 = calculateCharFrequency(s1);
        HashMap<Character, Integer> frequency2 = calculateCharFrequency(s2);
        for (char ch : frequency1.keySet()) {
            int chFrequency1 = frequency1.get(ch);
            int chFrequency2 = frequency2.get(ch);
            if (chFrequency1 != chFrequency2)
                return false;
        }
        return true;
    }

    private static HashMap<Character, Integer> calculateCharFrequency(String s) {
        HashMap<Character, Integer> frequency = new HashMap<>();
        for (char ch : s.toCharArray()) {
            frequency.merge(ch, 1, Integer::sum);
        }
        return frequency;
    }
}
