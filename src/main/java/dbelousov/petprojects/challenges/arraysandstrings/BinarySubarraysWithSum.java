package dbelousov.petprojects.challenges.arraysandstrings;

public class BinarySubarraysWithSum {

    private int[] nums;
    private int s = 0;
    private int subarraysCount = 0;

    public BinarySubarraysWithSum(int[] nums, int s) {
        this.nums = nums;
        this.s = s;
    }

    public int countSubarrays() {
        for (var i = 0; i < nums.length; i++) {
            var currSum = 0;
            countSubarraysInternal(i, currSum, false);
        }

        return subarraysCount;
    }

    private void countSubarraysInternal(int start, int currSum, boolean isFound) {
        if (nums.length - start > 0) {
            if (isFound && nums[start] != 1) {
                subarraysCount++;
                countSubarraysInternal(start + 1, currSum, true);
                return;
            }

            var foundAt = searchNext(start, 1);
            if (foundAt >= 0) {
                currSum++;
                if (currSum == s) {
                    subarraysCount++;
                    countSubarraysInternal(foundAt + 1, currSum, true);
                    return;
                }
                countSubarraysInternal(foundAt + 1, currSum, false);
            }
        }
    }

    private int searchNext(int start, int key) {
        for (var i = start; i < nums.length; i++) {
            if (nums[i] == key) {
                return i;
            }
        }

        return -1;
    }
}
