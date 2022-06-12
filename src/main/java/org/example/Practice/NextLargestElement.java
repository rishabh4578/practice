package org.example.Practice;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1/
 */
public class NextLargestElement {

    public static void main(String[] args) {
        long[] arr = {1, 3, 2, 4};
        long[] result = nextLargerElement(arr, 4);
        System.out.println(Arrays.stream(result).mapToObj(i -> String.valueOf(i)).collect(Collectors.joining(" -> ")));
    }

    public static long[] nextLargerElement(long[] arr, int n) {
        int len = arr.length;
        int[] nleIndices = new int[len];
        nleIndices[len - 1] = -1;
        for (int i = len - 2; i >= 0; i--) {
            int idx = i + 1;
            while (idx != -1) {
                if (arr[idx] > arr[i]) {
                    nleIndices[i] = idx;
                    break;
                } else {
                    idx = nleIndices[idx];
                }
            }
            if (idx == -1) nleIndices[i] = -1;
        }
        long[] result = new long[len];
        for (int i = 0; i < len; i++) {
            if (nleIndices[i] != -1) result[i] = arr[nleIndices[i]];
            else result[i] = -1;
        }
        return result;
    }
}
