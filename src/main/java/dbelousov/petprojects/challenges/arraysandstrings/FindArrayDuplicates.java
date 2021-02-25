package dbelousov.petprojects.challenges.arraysandstrings;

import java.util.ArrayList;

public class FindArrayDuplicates {
    public static Integer[] findDuplicates(Integer[] in) {
        var out = new ArrayList<Integer>();

        for (var i = 1; i <= in.length; i++) {
            var j = Math.abs(in[i - 1]);
            j--;
            if (in[j] >= 0) {
                in[j] = -in[j];
            } else {
                out.add(Math.abs(in[j]));
            }
        }

        return out.toArray(new Integer[0]);
    }
}
