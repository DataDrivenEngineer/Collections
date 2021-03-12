package dbelousov.petprojects.challenges.arraysandstrings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindPythagoreanTriplets {

    public static List<List<Integer>> findTriplets(int[] nums) {
        var squares = new HashSet<Integer>(nums.length);
        for (var num : nums) {
            squares.add((int) Math.pow(num, 2));
        }
        var out = new ArrayList<List<Integer>>();
        for (var i = 0; i < nums.length - 1; i++) {
            for (var j = i; j < nums.length; j++) {
                var sum = (int) (Math.pow(nums[i], 2) + Math.pow(nums[j], 2));
                if (squares.contains(sum)) {
                    var l = new ArrayList<Integer>(3);
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add((int) Math.sqrt(sum));
                    out.add(l);
                }
            }
        }
        return out;
    }
}
