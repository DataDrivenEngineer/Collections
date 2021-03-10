package dbelousov.petprojects.challenges.arraysandstrings;

public class SortListWithThreeUniqueNumbers {

    public static int[] sort(int[] in) {
        var si = -1;
        var curr = 0;
        while (curr < in.length) {
            if (in[curr] == 1) {
                si++;
                swap(in, si, curr);
            } else {
                curr++;
            }
        }

        curr = si + 1;
        var li = in.length;
        while (curr < li) {
            if (in[curr] == 3) {
                li--;
                swap(in, li, curr);
            } else {
                curr++;
            }
        }

        return in;
    }

    private static void swap(int[] in, int src, int target) {
        var tmp = in[src];
        in[src] = in[target];
        in[target] = tmp;
    }
}
