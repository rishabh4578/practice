package org.example.Practice;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://www.careercup.com/question?id=5638261762424832
 * asked in Amazon
 */
public class LargestNoWithGivenCountOfAdjacentSwaps {

    public static void main(String[] args) {
        solution(new int[]{1, 3, 5, 2, 4}, 3);
    }

    public static void solution(int[] arr, int swapsCnt) {
        int n = arr.length;
        int[] ref = arr.clone();

        //sort in desc order
        Arrays.sort(ref);
        for (int i = 0; i <= n / 2; i++) {
            swap(ref, i, n - 1 - i);
        }

        int refIdx = getRefIdx(arr, ref, n);
        while (swapsCnt > 0 && refIdx != n) {
            int maxIdxInRef = getMaxIdxInRef(arr, n, refIdx);
            swap(arr, maxIdxInRef, maxIdxInRef - 1);
            swapsCnt--;
            refIdx = getRefIdx(arr, ref, n);
        }

        System.out.println(Arrays.stream(arr).mapToObj(e -> String.valueOf(e)).collect(Collectors.joining()));
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static int getMaxIdxInRef(int[] arr, int n, int refIdx) {
        int maxIdx = refIdx + 1;
        for (int i = refIdx + 2; i < n; i++) {
            if (arr[i] > arr[maxIdx])
                maxIdx = i;
        }
        return maxIdx;
    }

    private static int getRefIdx(int[] arr, int[] ref, int n) {
        int i = 0;
        while (i < n && arr[i] == ref[i])
            i++;
        return i;
    }

}
