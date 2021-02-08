package dbelousov.petprojects.challenges.arraysandstrings;

import java.util.HashMap;

public class SpaceUrlifier {

    private static final String URL_CODE = "%20";

    public static char[] urlify(char[] s, int realLen) {
        if (s == null || s.length == 0) return null;

        HashMap<Integer, Character> nonSpaceIndexes = new HashMap<>();
        for (int i = 0; i < realLen; i++) {
            if (s[i] != ' ') {
                nonSpaceIndexes.put(i, s[i]);
            }
        }

        HashMap<Integer, Character> urlifiedIndexes = new HashMap<>();
        int spaceCount = 0;
        for (int i = 0; i < realLen; i++) {
            if (nonSpaceIndexes.get(i) == null) {
                spaceCount++;
            } else {
                urlifiedIndexes.put(i + (URL_CODE.length() - 1) * spaceCount, nonSpaceIndexes.get(i));
            }
        }

        return rewriteArray(s, urlifiedIndexes);
    }

    private static char[] rewriteArray(char[] s, HashMap<Integer, Character> indexes) {
        for (int i = 0; i < s.length; i++) {
            if (indexes.get(i) == null) {
                insertUrlCode(s, i);
                i += URL_CODE.length() - 1;
            } else {
                s[i] = indexes.get(i);
            }
        }
        return s;
    }

    private static void insertUrlCode(char[] s, int atIndex) {
        for (char ch : URL_CODE.toCharArray()) {
            s[atIndex] = ch;
            atIndex++;
        }
    }
}
