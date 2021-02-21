package dbelousov.petprojects.challenges.heap;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class KthFrequentElement {

    private int k = 1;
    private int[] nums;

    public KthFrequentElement(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
    }

    public int[] getKthFrequentElement() {
        if (nums == null) {
            return null;
        }

        var frequency = new HashMap<Integer, Integer>();
        for (var num : nums) {
            var f = frequency.get(num);
            if (f == null) {
                frequency.put(num, 1);
            } else {
                frequency.put(num, f + 1);
            }
        }

        var reversedFrequency = reverse(frequency);
        var keys = reversedFrequency.keySet();
        var heap = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (var key : keys) {
            heap.offer(key);
        }

        var ret = new int[k];
        for (var i = 0; i < k; i++) {
            ret[i] = reversedFrequency.get(heap.poll());
        }
        return ret;
    }

    private HashMap<Integer, Integer> reverse(HashMap<Integer, Integer> in) {
        var out = new HashMap<Integer, Integer>();
        var keys = in.keySet();
        for (var key : keys) {
            var value = in.get(key);
            out.put(value, key);
        }
        return out;
    }
}
