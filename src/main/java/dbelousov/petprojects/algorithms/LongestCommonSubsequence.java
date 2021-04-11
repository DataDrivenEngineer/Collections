package dbelousov.petprojects.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LongestCommonSubsequence {

    private final StringBuilder sb = new StringBuilder();

    public String calculateLcs(String s1, String s2) {
        if (s1.isEmpty() || s2.isEmpty()) return "";
        var m = new int[s1.length() + 1][s2.length() + 1];
        for (var i = 1; i <= s1.length(); i++) {
            for (var j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    m[i][j] = m[i - 1][j - 1] + 1;
                } else {
                    var lengthOne = m[i-1][j];
                    var lengthTwo = m[i][j-1];
                    m[i][j] = Math.max(lengthOne, lengthTwo);
                }
            }
        }
        buildLcs(s1, m, m.length-1, m[0].length-1);
        return sb.toString();
    }

    private void buildLcs(String s1, int[][] m, int i, int j) {
        if (i == 0 || j == 0) return;
        var thisLen = m[i][j];
        var leftLen = m[i][j-1];
        var upLen = m[i-1][j];
        if (thisLen == upLen) {
            buildLcs(s1, m, i-1, j);
        } else if (thisLen == leftLen) {
            buildLcs(s1, m, i, j-1);
        } else {
            buildLcs(s1, m, i-1, j-1);
            sb.append(s1.charAt(i-1));
        }
    }

    // region memoized

    private final class Pair {
        private final int row;
        private final int col;

        private Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return row == pair.row && col == pair.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
    private final Map<Pair, Integer> cache = new HashMap<>();

    public  String calculateLcsMemoized(String s1, String s2) {
        if (s1.isEmpty() || s2.isEmpty()) return "";
        var m = new int[s1.length() + 1][s2.length() + 1];
        for (var i = 1; i <= s1.length(); i++) {
            for (var j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    var key = new Pair(i, j);
                    if (cache.containsKey(key)) {
                        m[i][j] = cache.get(key);
                    } else {
                        m[i][j] = m[i - 1][j - 1] + 1;
                        cache.put(key, m[i][j]);
                    }
                } else {
                    var lengthOne = m[i-1][j];
                    var lengthTwo = m[i][j-1];
                    m[i][j] = Math.max(lengthOne, lengthTwo);
                }
            }
        }
        buildLcs(s1, m, m.length-1, m[0].length-1);
        return sb.toString();
    }

    // endregion memoized
}
