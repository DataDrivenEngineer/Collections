package dbelousov.petprojects.util;

public class SortUtils {

    public static <T extends Comparable<T>> void quickSort(T[] in) {
        quickSortInternal(in, 0, in.length - 1);
    }

    private static <T extends Comparable<T>> void quickSortInternal(T[] in, int left, int right) {
        if (left < right) {
            var sortedItemIndex = partition(in, left, right);
            quickSortInternal(in, left, sortedItemIndex - 1);
            quickSortInternal(in, sortedItemIndex + 1, right);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] in, int left, int right) {
        var indexOfSmaller = left - 1;
        var indexOfPivot = (left + right) / 2;
        for (var i = left; i <= right; i++) {
            if (in[i].compareTo(in[indexOfPivot]) < 0) {
                indexOfSmaller++;
                if (indexOfSmaller != indexOfPivot) {
                    swap(in, indexOfSmaller, i);
                } else {
                    swap(in, indexOfPivot + 1, i);
                    swap(in, indexOfPivot, indexOfPivot + 1);
                    indexOfPivot++;
                }
            }
        }
        return indexOfPivot;
    }

    private static <T extends Comparable<T>> void swap(T[] in, int left, int right) {
        var tmp = in[left];
        in[left] = in[right];
        in[right] = tmp;
    }
}
