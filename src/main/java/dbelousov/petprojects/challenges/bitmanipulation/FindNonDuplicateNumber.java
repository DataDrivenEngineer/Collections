package dbelousov.petprojects.challenges.bitmanipulation;

public class FindNonDuplicateNumber {
    public static int findNonDuplicate(int[] nums) {
        var nonDupe = 0;
        for (var num : nums) {
            nonDupe ^= num;
        }
        return nonDupe;
    }
}
