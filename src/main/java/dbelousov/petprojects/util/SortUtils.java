package dbelousov.petprojects.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortUtils {

    // region quicksort

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

    //endregion quicksort

    // region mergesort

    private static int[] merge(int[] left, int[] right) {
        var maxIter = left.length + right.length;
        var merged = new int[maxIter];
        var mergedCurrIndex = 0;
        var leftCurrIndex = 0;
        var rightCurrIndex = 0;

        for (var i = 0; i < maxIter; i++) {
            if (leftCurrIndex < left.length) {
                if (rightCurrIndex < right.length) {
                    if (left[leftCurrIndex] > right[rightCurrIndex]) {
                        merged[mergedCurrIndex] = right[rightCurrIndex];
                        rightCurrIndex++;
                    } else {
                        merged[mergedCurrIndex] = left[leftCurrIndex];
                        leftCurrIndex++;
                    }
                    mergedCurrIndex++;
                }
            }
        }

        while (leftCurrIndex < left.length) {
            merged[mergedCurrIndex] = left[leftCurrIndex];
            mergedCurrIndex++;
            leftCurrIndex++;
        }

        while (rightCurrIndex < right.length) {
            merged[mergedCurrIndex] = right[rightCurrIndex];
            mergedCurrIndex++;
            rightCurrIndex++;
        }

        return merged;
    }

    private static void swap(int[] one, int[] two, int i) {
        var tmp = one[i];
        one[i] = two[i];
        two[i] = tmp;
    }

    private static void swap(int[] one, int left, int right) {
        var tmp = one[left];
        one[left] = one[right];
        one[right] = tmp;
    }

    public static int[] mergeSort(int[] in) {
        if (in != null) {
            if (in.length == 1) {
                return in;
            }
            return mergeSortInternal(in);
        }
        return null;
    }

    private static int[] mergeSortInternal(int[] in) {
        if (in.length == 1) {
            return in;
        }

        int mid = in.length / 2;
        int[] left = getLeftPart(in, mid);
        int[] right = getRightPart(in, mid);
        left = mergeSortInternal(left);
        right = mergeSortInternal(right);
        return merge(left, right);
    }

    private static int[] getLeftPart(int[] in, int mid) {
        var ret = new int[mid];

        for (var i = 0; i < mid; i++) {
            ret[i] = in[i];
        }

        return ret;
    }

    private static int[] getRightPart(int[] in, int mid) {
        var ret = new int[in.length - mid];
        var retCurrIndex = 0;

        for (var i = mid; i < in.length; i++) {
            ret[retCurrIndex] = in[i];
            retCurrIndex++;
        }

        return ret;
    }

    //endregion mergesort
}
